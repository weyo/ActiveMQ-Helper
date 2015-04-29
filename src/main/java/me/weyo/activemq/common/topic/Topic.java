package me.weyo.activemq.common.topic;

import me.weyo.activemq.common.Consumer;
import me.weyo.activemq.common.Transaction;

/**
 * Topic
 * @author WeYo
 */
public interface Topic<E, T> extends Consumer<E>, Transaction<T> {
	
}
