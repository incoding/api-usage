package com.javaapi.test.spring.feature.function.init;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 参考 http://www.cnblogs.com/zhouqing/archive/2012/10/28/2743394.html
 *
 */
public class Client {
	@Test
	public void test() {
		System.out.println("====运行A中的main函数，准备载入xml配置文件====");
		String path = Client.class.getResource("").getPath();
		String filename = path + "applicationContext.xml";
		ApplicationContext app = new FileSystemXmlApplicationContext(filename);
		System.out.println("====xml配置文件载入完毕，准备获得bean D====");
		D d = (D) app.getBean("beand");
		System.out.println("====已经获取bean D，准备运行D中的方法methodOfD====");
		d.methodOfD();

	}
}