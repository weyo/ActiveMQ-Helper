package me.weyo.activemq.common;


/**
 * Producer
 * @author WeYo
 */
public interface Producer<T> {

	void produce(T p) throws Exception;
}
