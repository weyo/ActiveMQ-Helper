package me.weyo.activemq.common.queue;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 * QueueConnection
 * @author WeYo
 */
public class QueueConnection {
	protected String url;
	protected String queue;
	protected Connection connection;
	protected Session session;
	protected MessageConsumer consumer;
	protected MessageProducer producer;
	
	public QueueConnection(String url, String queue) {
		this.url = url;
		this.queue = queue;
	}
	
	protected void closeConsumer() throws JMSException {
		if (this.consumer != null) {
			this.consumer.close();
			this.consumer = null;
		}
	}
	
	protected void closeProducer() throws JMSException {
		if (this.producer != null) {
			this.producer.close();
			this.producer = null;
		}
	}
	
	protected void closeSession() throws JMSException {
		if (this.session != null) {
			this.session.close();
			this.session = null;
		}
	}
	
	protected void closeConnection() throws JMSException {
		if (this.connection != null) {
			this.connection.close();
			this.connection = null;
		}
	}
}
