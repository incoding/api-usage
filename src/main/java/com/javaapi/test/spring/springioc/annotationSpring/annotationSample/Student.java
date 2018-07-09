package com.javaapi.test.spring.springioc.annotationSpring.annotationSample;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private String	name	= "kk";
	private String	age;

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
