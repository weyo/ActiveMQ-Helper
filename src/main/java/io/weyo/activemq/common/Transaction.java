package io.weyo.activemq.common;

/**
 * Transaction
 * @author weyo
 */
public interface Transaction<T> extends Producer<T> {

	void commit() throws Exception;
}
