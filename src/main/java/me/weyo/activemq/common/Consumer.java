package me.weyo.activemq.common;


/**
 * Consumer
 * @author WeYo
 */
public interface Consumer<E> extends Connector{

	E consume() throws Exception;
}
