package io.weyo.activemq.common.jms;

import javax.jms.Message;


/**
 * SimpleQueueConsumer
 * @author weyo
 */
public class SimpleQueueConsumer extends MessageQueueConsumer {

	public SimpleQueueConsumer(String url, String queue) {
		super(url, queue);
	}

	@Override
	public Message consume() {
		return null;
	}

}
