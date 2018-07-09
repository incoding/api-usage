package com.javaapi.test.spring.aop.aspectj.xml1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * aspectj +spring ,xml
 *Spring + AspectJ（基于配置）
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	private MyBService myBService;
	@Test
	public void test(){
		myBService.foo();
	}
}
