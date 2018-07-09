package com.javaapi.test.application.cache.memcache.xmemcache;

import org.junit.Test;

public class TestString {
	public static final byte[]	CRLF	= { '\r', '\n' };
	public static final byte[]	GET		= { 'g', 'e', 't' };
	public static final byte[]	GETS	= { 'g', 'e', 't', 's' };
	public static final byte	SPACE	= ' ';
	public static final byte[]	INCR	= { 'i', 'n', 'c', 'r' };
	public static final byte[]	DECR	= { 'd', 'e', 'c', 'r' };
	public static final byte[]	DELETE	= { 'd', 'e', 'l', 'e', 't', 'e' };
	public static final byte[]	TOUCH	= { 't', 'o', 'u', 'c', 'h' };

	@Test
	public void test() {
		System.out.println(TestString.GET[0]);
		System.out.println(TestString.GET.length);
	}
}
