package me.weyo.activemq.common.jms;

import javax.jms.JMSException;

/**
 * SimpleQueueProducer
 * @author WeYo
 */
public class SimpleQueueProducer extends MessageQueueProducer {

	public SimpleQueueProducer(String url, String queue) {
		super(url, queue);
		this.queueConnector = new DefaultQueueConnector(url, queue);
	}

	@Override
	public void produce(String p) throws JMSException {
		queueConnector.produce(p);
	}

	@Override
	public void connect() throws JMSException {
		this.queueConnector.connect();
		this.queueConnector.setProducer();
	}

	@Override
	public void close() throws JMSException {
		this.queueConnector.closeProducer();
		this.queueConnector.close();
	}

}
