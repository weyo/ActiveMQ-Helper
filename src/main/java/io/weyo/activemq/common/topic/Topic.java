package io.weyo.activemq.common.topic;

/**
 * Topic
 * @author weyo
 */
public class Topic {
	private String name;
	private Offset offset;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Offset getOffset() {
		return offset;
	}

	public void setOffset(Offset offset) {
		this.offset = offset;
	}

	class Offset {
		long size;
		long position;
	}
}
