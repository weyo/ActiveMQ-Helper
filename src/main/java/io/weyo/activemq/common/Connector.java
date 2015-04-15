package io.weyo.activemq.common;

/**
 * Connector
 * @author weyo
 */
public interface Connector {
	void connect();
	
	void close();
}
