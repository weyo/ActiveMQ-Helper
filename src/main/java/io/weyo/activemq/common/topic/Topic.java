package io.weyo.activemq.common.topic;

import io.weyo.activemq.common.Consumer;
import io.weyo.activemq.common.Transaction;

/**
 * Topic
 * @author weyo
 */
public interface Topic<E, T> extends Consumer<E>, Transaction<T> {
	
}
