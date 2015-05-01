package me.weyo.activemq.common;


/**
 * Connector
 * @author WeYo
 */
public interface Connector {
	/**
	 * create a connection to a message system
	 * @throws Exception
	 */
	void connect() throws Exception;
	
	/**
	 * close the connection
	 * @throws Exception
	 */
	void close() throws Exception;
}
