package com.javaapi.test.spring.aop.springaop1ProxyFactoryBean1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingImpl implements Greeting {

	@Autowired
	Teacher	teacher;

	@Override
	public void sayHello(String name) {
		System.out.println(teacher.getName());
		System.out.println("hello");
	}

	@Override
	public void sayGoodBy(String name) {
		System.out.println("sayGoodBy");
	}

}