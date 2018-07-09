package com.javaapi.test.spring.springioc.xmlSpring.factorybean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 */
public class SpringTest {
	@Test
	public void test() {
		String path=SpringTest.class.getResource("").getPath();
		String filename = path+"applicationContext.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
		System.out.println(app);
		School school=(School)app.getBean("school");
		school.haveClass();//上课
		System.out.println("------");
		School school2=(School)app.getBean("school");
	}
	@Test
	public void testGetFactoryOriginBean() {
		String path=SpringTest.class.getResource("").getPath();
		String filename = path+"applicationContext.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
		Object bean = app.getBean("studentFactory");
		System.out.println(bean);
		Object bean2 = app.getBean("&studentFactory");
		System.out.println(bean2);
		System.out.println("---------");
		Object bean3 = app.getBean("studentFactory");
		System.out.println("------------");
		Student bean4 = app.getBean("studentFactory",Student.class);
		System.out.println(bean4);
	}
}
