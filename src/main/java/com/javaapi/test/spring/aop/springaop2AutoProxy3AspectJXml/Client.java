package com.javaapi.test.spring.aop.springaop2AutoProxy3AspectJXml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javaapi.test.spring.aop.aspectj.MyBService;

/**
 * 请看 com.javaapi.test.spring.aop.aspectj 下的信息
 * 使用AspectJAwareAdvisorAutoProxyCreator 作为自动代理, 注意 与 aspectj 注解方式的自动代理不同
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

	@Autowired
	MyBService myBService;
	
	@Test
	public void test(){
		myBService.foo();
	}
}
