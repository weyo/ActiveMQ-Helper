package me.weyo.activemq.common.jms;

import javax.jms.JMSException;

import me.weyo.activemq.common.queue.Queue;

/**
 * QueueConnector
 * @author WeYo
 * @param <E> Type of message to be consumed
 * @param <T> Type of message to be produced
 */
public interface QueueConnector<E, T> extends ActiveMQConnector, Queue<E, T> {
	
	void setConsumer() throws JMSException;
	void setProducer() throws JMSException;
	void closeConsumer() throws JMSException;
	void closeProducer() throws JMSException;

}
