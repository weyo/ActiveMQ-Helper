package io.weyo.activemq.common.jms;

import javax.jms.JMSException;

import io.weyo.activemq.common.queue.Queue;

/**
 * QueueConnector
 * @author weyo
 * @param <E>
 */
public abstract class AbstractQueueConnector<E, T> extends AbstractActiveMQConnector implements Queue<E, T> {

	protected AbstractQueueConnector() {
	}
	
	@Override public abstract E consume() throws JMSException;
	@Override public abstract void produce(T p) throws JMSException;
	@Override public abstract void commit() throws JMSException;
	
	public abstract void setConsumer() throws JMSException;
	public abstract void setProducer() throws JMSException;
	public abstract void closeConsumer() throws JMSException;
	public abstract void closeProducer() throws JMSException;

}
