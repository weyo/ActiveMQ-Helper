package io.weyo.activemq.common.jms;

import javax.jms.JMSException;
import javax.jms.Message;


/**
 * SimpleQueueConsumer
 * @author weyo
 */
public class SimpleQueueConsumer extends MessageQueueConsumer {

	public SimpleQueueConsumer(String url, String queue) {
		super(url, queue);
		this.queueConnector = new DefaultQueueConnector(url, queue);
	}

	@Override
	public Message consume() throws JMSException {
		return this.queueConnector.consume();
	}

	@Override
	public void connect() throws JMSException {
		this.queueConnector.connect();
		this.queueConnector.setConsumer();
	}

	@Override
	public void close() throws JMSException {
		this.queueConnector.closeConsumer();
		this.queueConnector.close();
	}
}
