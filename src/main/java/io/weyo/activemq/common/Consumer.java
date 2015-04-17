package io.weyo.activemq.common;


/**
 * Consumer
 * @author weyo
 */
public interface Consumer<E> extends Connector{

	E consume() throws Exception;
}
