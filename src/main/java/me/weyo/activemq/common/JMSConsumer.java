package me.weyo.activemq.common;

import javax.jms.JMSException;

/**
 * JMSConsumer
 * 
 * @author WeYo
 */
public interface JMSConsumer<E> extends Consumer<E>, JMSConnector {

	/**
	 * consume message with a default timeout (1000ms)
	 */
	@Override
	E consume() throws JMSException;
	
	/**
	 * consume message with a specific timeout
	 */
	@Override
	E consume(long timeout) throws JMSException;
}
