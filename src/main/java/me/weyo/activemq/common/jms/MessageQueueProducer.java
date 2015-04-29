package me.weyo.activemq.common.jms;

import javax.jms.Message;

import me.weyo.activemq.common.Producer;

/**
 * MessageQueueProducer
 * @author WeYo
 */
public abstract class MessageQueueProducer implements ActiveMQConnector, Producer<String> {
	
	protected String url;
	protected String queue;
	protected QueueConnector<Message, String> queueConnector;

	public MessageQueueProducer(String url, String queue) {
		this.url = url;
		this.queue = queue;
	}
}
