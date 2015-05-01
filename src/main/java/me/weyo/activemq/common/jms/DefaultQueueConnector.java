package me.weyo.activemq.common.jms;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import me.weyo.activemq.common.queue.QueueConnection;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * DefaultQueueConnector
 * 
 * @author WeYo
 */
public class DefaultQueueConnector extends QueueConnection implements QueueConnector<Message, String> {

	private Destination destination;

	public DefaultQueueConnector(String url, String queue) {
		this.url = url;
		this.queue = queue;
	}

	@Override
	public Message consume() throws JMSException {
		return consume(1000);
	}

	public Message consume(long timeout) throws JMSException {
		return consumer.receive(timeout);
	}

	@Override
	public void produce(String message) throws JMSException {
		this.producer.send(session.createTextMessage(message));
	}

	@Override
	public void commit() throws JMSException {
		this.session.commit();
	}

	@Override
	public void connect() throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				this.url);
		this.connection = connectionFactory.createConnection();
		this.connection.start();
		this.session = connection.createSession(Boolean.FALSE,
				Session.AUTO_ACKNOWLEDGE);
		this.destination = this.session.createQueue(queue);
	}

	@Override
	public void close() throws JMSException {
		this.session.close();
		this.connection.close();
	}

	@Override
	public void setConsumer() throws JMSException {
		this.consumer = this.session.createConsumer(destination);
	}

	@Override
	public void closeConsumer() throws JMSException {
		this.consumer.close();
	}

	@Override
	public void closeProducer() throws JMSException {
		this.producer.close();
	}

	@Override
	public void setProducer() throws JMSException {
		this.producer = this.session.createProducer(destination);
		this.producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	}
}
