package me.weyo.activemq.common;


/**
 * Connector
 * @author WeYo
 */
public interface Connector {
	void connect() throws Exception;
	
	void close() throws Exception;
}
