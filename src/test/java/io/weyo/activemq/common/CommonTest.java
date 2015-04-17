package io.weyo.activemq.common;

import io.weyo.activemq.common.jms.SimpleQueueConsumer;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * CommonTest
 * 
 * @author weyo
 */
public class CommonTest {
	private static final String DEFAULT_HOST = "192.168.2.233";
	private static final String DEFAULT_QUEUE = "testQueue";
	
	private Consumer<?> consumer;
	private String url;
	private String queue;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.url = null;
		this.queue = null;
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test case for SimpleQueueConsumer
	 */
	@Test
	public void test001() {
		url = new StringBuilder("tcp://").append(DEFAULT_HOST).append(":61616").toString();
		queue = DEFAULT_QUEUE;
		consumer = new SimpleQueueConsumer(url, queue);
		
		try {
			consumer.connect();
			Message message = (Message) consumer.consume();
			if (message == null) {
				System.err.println("[AFEE] There is no messge in the queue right now.");
				throw new NullPointerException();
			}
			TextMessage text = (TextMessage) message;
			String str = text.getText();
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				consumer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
