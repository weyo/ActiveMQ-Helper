package me.weyo.activemq.common.queue;

import me.weyo.activemq.common.JMSConsumer;
import me.weyo.activemq.common.Transaction;

/**
 * Queue
 * @author WeYo
 */
public interface Queue<E, T> extends JMSConsumer<E>, Transaction<T>{
	
}
