package com.javaapi.test.spring.feature.config.propertyplaceholder.contextplaceholder;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class ClientPlain {
	@Test
	public void test() {
//		String path=Client.class.getResource("").getPath();
		String path=Client.class.getResource("").getPath();
		String filename = path+"applicationContext.xml";
		ApplicationContext app=new FileSystemXmlApplicationContext("file:"+filename);
		TaskJobXml bean = (TaskJobXml) app.getBean("taskJobXml");
		bean.job1();
		System.out.println(bean.getTaskName());
	}
}