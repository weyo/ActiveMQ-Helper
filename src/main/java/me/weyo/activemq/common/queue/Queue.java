package me.weyo.activemq.common.queue;

import me.weyo.activemq.common.Consumer;
import me.weyo.activemq.common.Transaction;

/**
 * Queue
 * @author WeYo
 */
public interface Queue<E, T> extends Consumer<E>, Transaction<T>{
	
}
