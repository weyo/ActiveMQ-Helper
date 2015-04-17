package io.weyo.activemq.common.queue;

import io.weyo.activemq.common.Consumer;
import io.weyo.activemq.common.Transaction;

/**
 * Queue
 * @author weyo
 */
public interface Queue<E, T> extends Consumer<E>, Transaction<T>{
	
}
