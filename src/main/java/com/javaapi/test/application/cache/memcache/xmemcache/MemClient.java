package com.javaapi.test.application.cache.memcache.xmemcache;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.junit.Test;


public class MemClient {

	private static final int		port	= 11211;
	private static final String	ip	= "127.0.0.1";
	private static XMemcachedClient	client;
	static {
		try {
			client = new XMemcachedClient(ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void set() throws TimeoutException, InterruptedException,
	MemcachedException {
		if (!client.set("hello", 0, "dennis")) {
			System.err.println(" set error ");
		}
	}

	@Test
	public void add() throws TimeoutException, InterruptedException,
			MemcachedException {
		client.add("hello", 0, "dennis");
	}

	@Test
	public void replace() throws TimeoutException, InterruptedException,
			MemcachedException {
		client.replace("hello", 0, "dennis");
	}

	@Test
	public void get() throws TimeoutException, InterruptedException,
			MemcachedException {
		// 批量获取
		List<String> keys = new ArrayList<String>();
		keys.add("hello");
		keys.add("test");
		Map<String, Object> map = client.get(keys);
		System.out.println(map);
	}

	@Test
	public void delete() throws TimeoutException, InterruptedException,
			MemcachedException {
		// delete操作
		if (!client.delete("hello", 1000)) {
			System.err.println(" delete error ");
		}
	}

	@Test
	public void incr() throws TimeoutException, InterruptedException,
			MemcachedException {
		client.incr("a", 4);
	}

	@Test
	public void decr() throws TimeoutException, InterruptedException,
			MemcachedException {
		client.decr("a", 4);
	}

	@Test
	public void selfdefine() throws TimeoutException, InterruptedException,
			MemcachedException, IOException {
		// 增删改查自定义对象
		Name dennis = new Name("dennis", "zhuang", 26, -1);
		System.out.println("dennis: " + dennis);
		client.set("dennis", 0, dennis);

		Name cachedPerson = (Name) client.get("dennis");
		System.out.println("cachedPerson: " + cachedPerson);
		cachedPerson.money = -10000;

		client.replace("dennis", 0, cachedPerson);
		Name cachedPerson2 = (Name) client.get("dennis");
		System.out.println(" cachedPerson2: " + cachedPerson2);

		// delete
		client.delete("dennis");
		System.out.println(" after delete: " + client.get("dennis"));
		client.shutdown();
	}
}