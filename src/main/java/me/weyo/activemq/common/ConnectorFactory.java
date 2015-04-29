package me.weyo.activemq.common;

import me.weyo.activemq.common.jms.QueueConnector;
import me.weyo.activemq.common.jms.DefaultQueueConnector;

/**
 * ConnectorFactory
 * @author WeYo
 */
public class ConnectorFactory {

	public QueueConnector<?, ?> createQueueConnector(String url, String queue) {
		return new DefaultQueueConnector(url, queue);
	}

}
