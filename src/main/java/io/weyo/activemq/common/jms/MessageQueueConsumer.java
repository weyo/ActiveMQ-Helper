package io.weyo.activemq.common.jms;

import javax.jms.Message;

import io.weyo.activemq.common.Consumer;

/**
 * AbstractQueueConsumer
 * @author weyo
 */
public abstract class MessageQueueConsumer implements Consumer<Message> {

	protected String url;
	protected String queue;
	protected AbstractQueueConnector<Message> queueConnector;
	
	public MessageQueueConsumer(String url, String queue) {
		this(url, queue, null);
	}

	public MessageQueueConsumer(String url, String queue, AbstractQueueConnector<Message> queueConnector) {
		this.url = url;
		this.queue = queue;
		if (queueConnector == null) {
			this.queueConnector = new DefaultQueueConnector();
		} else {
			this.queueConnector = queueConnector;
		}
	}
}
