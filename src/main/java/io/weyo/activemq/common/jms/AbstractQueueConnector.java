package io.weyo.activemq.common.jms;

import io.weyo.activemq.common.queue.Queue;

/**
 * QueueConnector
 * @author weyo
 * @param <E>
 */
public abstract class AbstractQueueConnector<E> extends AbstractActiveMQConnector implements Queue<E> {

	protected AbstractQueueConnector() {
	}
}
