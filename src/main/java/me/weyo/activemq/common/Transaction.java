package me.weyo.activemq.common;

import javax.jms.JMSException;

/**
 * Transaction
 * 
 * @author WeYo
 */
public interface Transaction<T> extends Producer<T> {

	@Override
	void produce(T p) throws JMSException;

	void commit() throws JMSException;
}
