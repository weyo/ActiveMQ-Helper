package io.weyo.activemq.common;


/**
 * Connector
 * @author weyo
 */
public interface Connector {
	void connect() throws Exception;
	
	void close() throws Exception;
}
