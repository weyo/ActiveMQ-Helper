package me.weyo.activemq.common.jms;

import me.weyo.activemq.common.JMSConnector;

/**
 * JMSConnector
 * @author WeYo
 */
public interface ActiveMQConnector extends JMSConnector {

	enum State {
		CONNECTING, CONNECTED, CLOSED
	}
	
}
