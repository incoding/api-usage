package com.javaapi.test.spring.feature.bug;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 代理bean是否是prototype,最终获取得是否是prototype,跟target bean有关系.</br>
 * 注意即使调用app.isPrototype("greetingProxy")或者app.isSingleton("greetingProxy"),也不能判断最终生成的是否是不同实例
 */
public class TestBug {
	@Test
	public void test() {
		String path = TestBug.class.getResource("").getPath();
		System.out.println(path);
		String filename = path + "applicationContextBug.xml";
		ApplicationContext app = new FileSystemXmlApplicationContext(filename);
		Greeting greeting = (Greeting) app.getBean("greetingProxy");
		Greeting greeting2 = (Greeting) app.getBean("greetingProxy");
		greeting.sayHello("jack");
		greeting.goodMorning("kk");
		System.out.println(greeting);
		System.out.println(greeting2);
		System.out.println(app.isPrototype("greetingProxy"));
		System.out.println(app.isSingleton("greetingProxy"));
	}
}
