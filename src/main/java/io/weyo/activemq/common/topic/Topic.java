package io.weyo.activemq.common.topic;

import io.weyo.activemq.common.Consumer;
import io.weyo.activemq.common.Producer;

/**
 * Topic
 * @author weyo
 */
public interface Topic<E> extends Consumer<E>, Producer {
	
}
