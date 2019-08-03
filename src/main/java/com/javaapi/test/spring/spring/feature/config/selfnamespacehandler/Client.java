package com.javaapi.test.spring.spring.feature.config.selfnamespacehandler;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * http://blog.sina.com.cn/s/blog_551d2eea0101dzbn.html (实践)好
 * http://singleant.iteye.com/blog/1179948(原理)还可以
 * 
 */
public class Client {

	@Test
	public void test() {
		String path = Client.class.getResource("").getPath();
		String file = path + "applicationContext.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(file);
		People p = (People) ctx.getBean("cutesource");
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}
}
