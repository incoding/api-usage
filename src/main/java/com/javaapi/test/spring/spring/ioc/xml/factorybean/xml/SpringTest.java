package com.javaapi.test.spring.spring.ioc.xml.factorybean.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *测试如何在xml中注入factorybean原始bean
 */
public class SpringTest {
	@Test
	public void test() {
		String path=SpringTest.class.getResource("").getPath();
		String filename = path+"applicationContext.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
		TeacherImp teacher = (TeacherImp) app.getBean("teacher");
		System.out.println(teacher.getStudent());
	}
}
