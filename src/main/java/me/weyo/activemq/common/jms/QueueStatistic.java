package me.weyo.activemq.common.jms;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import me.weyo.activemq.common.queue.QueueConnection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

/**
 * A usable statistic tool for retrieving statistics from ActiveMQ broker or its
 * destinations. Some important statistic attributes and their <em>Chinese</em>
 * explanations can be found as follows.
 * <p>
 * <table>
 * <tr align="left">
 * <th bgcolor="#CCCCCC" align="center" id="construct">消息队列属性(Attributes)</th>
 * <th bgcolor="#CCCCCC" align="center" id="matches">说明(Explanations)</th>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>size</i></td>
 * <td headers="matches">队列中未消费的数据数量</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>memoryUsage</i></td>
 * <td headers="matches">可用数据存储空间大小</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>dequeueCount</i></td>
 * <td headers="matches">已消费的数据数量</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>averageEnqueueTime</i></td>
 * <td headers="matches">数据平均入列时间</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>destinationName</i></td>
 * <td headers="matches">当前队列名称</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>averageMessageSize</i></td>
 * <td headers="matches">平均数据大小</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>memoryPercentUsage</i></td>
 * <td headers="matches">占用的内存大小（百分比）</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>producerCount</i></td>
 * <td headers="matches">生产者数量</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>consumerCount</i></td>
 * <td headers="matches">消费者数量</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>minEnqueueTime</i></td>
 * <td headers="matches">数据最小入列时间</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>expiredCount</i></td>
 * <td headers="matches">超时数量</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>dispatchCount</i></td>
 * <td headers="matches">数据分发数量</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>maxEnqueueTime</i></td>
 * <td headers="matches">数据最大入列时间</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>enqueueCount</i></td>
 * <td headers="matches">已入列数据数量</td>
 * </tr>
 * <tr>
 * <td valign="top" headers="construct characters"><i>memoryLimit</i></td>
 * <td headers="matches">队列可以使用的最大存储容量</td>
 * </tr>
 * </table>
 * </p>
 * <p>
 * To use this class, you should make sure that the statistics plugin has been
 * configured in the ActiveMQ XML Configuration file like this:
 * 
 * <pre>
 * {@code
 * <broker ...>
 *   <plugins>
 *     <statisticsBrokerPlugin/>
 *   </plugins>
 * </broker>}
 * </pre>
 * 
 * Any more information can be found from <a href
 * ="http://activemq.apache.org/statisticsplugin.html"><strong>ActiveMQ
 * StatisticsPlugin Page</strong></a>.
 * </p>
 * 
 * @author WeYo
 */
public class QueueStatistic extends QueueConnection implements
		ActiveMQConnector {
	private static final Logger LOG = Logger.getLogger(QueueStatistic.class);
	private MapMessage reply;

	public QueueStatistic(String url, String queue) {
		super(url, queue);
	}

	@Override
	public void connect() throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				this.url);
		this.connection = connectionFactory.createConnection();
		this.connection.start();
		this.connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
	}

	/**
	 * Get the specific statistic value of a queue
	 * 
	 * @param name
	 *            the attribute of the queue
	 * @return the value of the specific attribute
	 * @throws JMSException
	 */
	public Object getValue(String name) throws JMSException {
		Queue replyTo = this.session.createTemporaryQueue();
		consumer = this.session.createConsumer(replyTo);
		Queue testQueue = this.session.createQueue(this.queue);
		producer = this.session.createProducer(null);
		String queueName = "ActiveMQ.Statistics.Destination."
				+ testQueue.getQueueName();
		Queue query = this.session.createQueue(queueName);
		Message msg = this.session.createMessage();
		producer.send(testQueue, msg);
		msg.setJMSReplyTo(replyTo);
		producer.send(query, msg);
		reply = (MapMessage) consumer.receive();

		if ((reply == null) || (!reply.getMapNames().hasMoreElements())) {
			LOG.error("This queue(" + this.queue
					+ ") has no statistics message.");
			return null;
		}

		return reply.getObject(name);
	}

	@Override
	public void close() throws JMSException {
		closeConsumer();
		closeProducer();
		closeSession();
		closeConnection();
	}
}
