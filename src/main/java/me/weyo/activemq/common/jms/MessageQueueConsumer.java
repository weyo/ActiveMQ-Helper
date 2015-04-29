package me.weyo.activemq.common.jms;

import javax.jms.Message;

import me.weyo.activemq.common.Consumer;

/**
 * MessageQueueConsumer
 * 
 * @author WeYo
 */
public abstract class MessageQueueConsumer implements ActiveMQConnector, Consumer<Message> {

	protected String url;
	protected String queue;
	protected QueueConnector<Message, ?> queueConnector;

	public MessageQueueConsumer(String url, String queue) {
		this.url = url;
		this.queue = queue;
	}
}
