package io.weyo.activemq.common.jms;

import io.weyo.activemq.common.Producer;

import javax.jms.Message;

/**
 * MessageQueueProducer
 * @author weyo
 */
public abstract class MessageQueueProducer extends AbstractActiveMQConnector
		implements Producer<String> {
	
	protected String url;
	protected String queue;
	protected AbstractQueueConnector<Message, ?> queueConnector;

	public MessageQueueProducer(String url, String queue) {
		this.url = url;
		this.queue = queue;
	}
}
