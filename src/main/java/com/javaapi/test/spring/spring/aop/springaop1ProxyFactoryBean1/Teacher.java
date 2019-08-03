package com.javaapi.test.spring.spring.aop.springaop1ProxyFactoryBean1;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
	String	name	= "kk";
	String	age		= "18";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
