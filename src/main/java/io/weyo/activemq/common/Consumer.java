package io.weyo.activemq.common;

/**
 * Consumer
 * @author weyo
 */
public interface Consumer<E> {

	E consume();
}
