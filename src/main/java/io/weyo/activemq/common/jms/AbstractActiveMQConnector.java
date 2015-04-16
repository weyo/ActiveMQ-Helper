package io.weyo.activemq.common.jms;

import io.weyo.activemq.common.Controller;

import javax.jms.Connection;
import javax.jms.Session;

/**
 * AbstractActiveMQConnector
 * @author weyo
 */
public abstract class AbstractActiveMQConnector extends JMSConnector implements Controller{

	protected Connection connection = null;
	protected Session session = null;
	
	protected AbstractActiveMQConnector() {
	}
	
	@Override
	public final void start() {
		initialize();
	}
	
	@Override
	public final void stop() {
		endEngine();
	}

	protected abstract void initialize();
	protected abstract void endEngine();
}
