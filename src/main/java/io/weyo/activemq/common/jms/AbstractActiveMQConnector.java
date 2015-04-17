package io.weyo.activemq.common.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * AbstractActiveMQConnector
 * @author weyo
 */
public abstract class AbstractActiveMQConnector extends JMSConnector{

	protected Connection connection = null;
	protected Session session = null;
	
	protected AbstractActiveMQConnector() {
	}

	@Override public abstract void connect() throws JMSException;
	@Override public abstract void close() throws JMSException;
}
