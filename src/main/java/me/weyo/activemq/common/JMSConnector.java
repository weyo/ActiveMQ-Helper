package me.weyo.activemq.common;

import javax.jms.JMSException;

/**
 * JMSConnector
 * 
 * @author WeYo
 */
public interface JMSConnector extends Connector {

	@Override
	void connect() throws JMSException;

	@Override
	void close() throws JMSException;
}
