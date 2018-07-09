package com.javaapi.test.application.cache.memcache.xmemcache.SampleClient;

public class MemResponse {
	public static final MemResponse	ERROR	= new MemResponse("1", "ERROR");
	public static final MemResponse	STORED	= new MemResponse("2", "STORED");

	private String	id;
	private String	msg;

	public String getId() {
		return id;
	}

	public MemResponse(String id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
