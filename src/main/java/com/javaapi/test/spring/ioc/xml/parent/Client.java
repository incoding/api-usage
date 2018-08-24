package com.javaapi.test.spring.ioc.xml.parent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	Teacher teacher;
	@Autowired
	Worker worker;
	@Test
	public void test() {
		System.out.println(teacher.getName());
		System.out.println(teacher.getAge());
		
		System.out.println(worker.getHome());
	}
}
