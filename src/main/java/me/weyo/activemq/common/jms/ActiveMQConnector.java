package me.weyo.activemq.common.jms;

import javax.jms.JMSException;

import me.weyo.activemq.common.Connector;

/**
 * JMSConnector
 * @author WeYo
 */
public interface ActiveMQConnector extends Connector {

	enum State {
		CONNECTING, CONNECTED, CLOSED
	}
	
	@Override void connect() throws JMSException;
	@Override void close() throws JMSException;
}
