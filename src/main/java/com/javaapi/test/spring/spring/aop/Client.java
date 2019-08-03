package com.javaapi.test.spring.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	// 好像不能根据类型自动注入
	@Autowired
	@Qualifier("personProxy")
	private Person person;
	@Test
	public void test(){
		person.info();
		System.out.println("---------------");
//		try {
//			person.show("hello world");
//		} catch (FileNotFoundException e) {
//			System.out.println("调用抓住异常==>"+e.getMessage());
////			e.printStackTrace();
//		}
	}
}
