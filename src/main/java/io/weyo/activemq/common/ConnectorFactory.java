package io.weyo.activemq.common;

import io.weyo.activemq.common.jms.AbstractQueueConnector;
import io.weyo.activemq.common.jms.DefaultQueueConnector;

/**
 * ConnectorFactory
 * @author weyo
 */
public class ConnectorFactory {

	public AbstractQueueConnector<?, ?> createQueueConnector(String url, String queue) {
		return new DefaultQueueConnector(url, queue);
	}

}
