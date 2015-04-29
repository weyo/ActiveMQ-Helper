package me.weyo.activemq.common;

/**
 * Transaction
 * @author WeYo
 */
public interface Transaction<T> extends Producer<T> {

	void commit() throws Exception;
}
