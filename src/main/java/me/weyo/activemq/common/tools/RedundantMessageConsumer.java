package me.weyo.activemq.common.tools;

import javax.jms.JMSException;

import me.weyo.activemq.common.JMSConsumer;
import me.weyo.activemq.common.jms.QueueStatistic;
import me.weyo.activemq.common.jms.SimpleQueueConsumer;

import org.apache.log4j.Logger;

/**
 * A message consumer used to consume redundant messages in a queue. This class
 * should be used before {@code MessageQueueConsumer.consume()}.
 * <p>
 * <b>Usage</b>
 * 
 * <pre>
 * RedundantMessageconsumer consumer = new RedundantMessageConsumer();
 * consumer.consume(url, queue);
 * </pre>
 * 
 * @author WeYo
 */
public class RedundantMessageConsumer {
	private static final Logger LOG = Logger.getLogger(QueueStatistic.class);

	private JMSConsumer<?> consumer;
	private QueueStatistic statistics;

	/**
	 * Take out all messages of the specific queue.
	 * 
	 * @throws JMSException
	 */
	public void consume(String url, String queue) throws JMSException {
		initialize(url, queue);

		long t1 = System.currentTimeMillis();
		Object st = statistics.getValue("size");
		long size = st == null ? 0 : (Long) st;
		long count = 0;
		while (count < size) {
			Object message = consumer.consume();
			if (message != null) {
				count++;
			}
		}
		long t2 = System.currentTimeMillis();
		LOG.info((size > 0 ? --size : 0) + " messages left in " + url
				+ "/queue:" + queue + "have been taken. (time cost = "
				+ (t2 - t1) + "ms.");

		close();
	}

	private void initialize(String url, String queue) throws JMSException {
		this.consumer = new SimpleQueueConsumer(url, queue);
		this.statistics = new QueueStatistic(url, queue);
		this.statistics.connect();
		this.consumer.connect();
	}

	private void close() throws JMSException {
		this.statistics.close();
		this.consumer.close();
	}
}
