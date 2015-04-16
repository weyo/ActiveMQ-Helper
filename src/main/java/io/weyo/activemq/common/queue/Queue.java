package io.weyo.activemq.common.queue;

import io.weyo.activemq.common.Consumer;
import io.weyo.activemq.common.Producer;

/**
 * Queue
 * @author weyo
 */
public interface Queue<E> extends Consumer<E>, Producer{
	
}
