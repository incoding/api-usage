package com.javaapi.test.test.proxy.cglib.cglibaop2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.javaapi.test.test.proxy.cglib.Dog;
import com.javaapi.test.test.proxy.cglib.cglibaop2.proxy.Proxy;
import com.javaapi.test.test.proxy.cglib.cglibaop2.proxy.ProxyManager;

/**
 * AOP,一种类似struts拦截器链的实现方式
 *
 */
public class Client {
	@Test
	public void testProxy() {
		List<Proxy> proxyList = new ArrayList<Proxy>();
		proxyList.add(new MyAopTest());
		proxyList.add(new MyAopTest2());
		Dog dog=(Dog)	ProxyManager.createProxy(Dog.class, proxyList);
		dog.active("waw,waw");
	}
}
