package io.weyo.activemq.common.jms;

import io.weyo.activemq.common.Consumer;

import javax.jms.Message;

/**
 * AbstractQueueConsumer
 * 
 * @author weyo
 */
public abstract class MessageQueueConsumer extends AbstractActiveMQConnector
		implements Consumer<Message> {

	protected String url;
	protected String queue;
	protected AbstractQueueConnector<Message, ?> queueConnector;

	public MessageQueueConsumer(String url, String queue) {
		this.url = url;
		this.queue = queue;
	}
}
