package com.javaapi.test.spring.spring.ioc.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * http://pingping0524.iteye.com/blog/262482
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
	}
	
	@Test
	public void testConstruct() {
		String path=SpringTest.class.getResource("").getPath();
		String filename = path+"applicationContext-construct.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
		System.out.println(app);
		Student school=(Student)app.getBean("student");
		System.err.println(school.getAge());
	}
}
