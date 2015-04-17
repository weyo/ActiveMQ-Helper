package io.weyo.activemq.common;


/**
 * Producer
 * @author weyo
 */
public interface Producer<T> {

	void produce(T p) throws Exception;
}
