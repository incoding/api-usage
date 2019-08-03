package com.javaapi.test.spring.spring.ioc.xml.factorybean.xml;

import com.javaapi.test.spring.spring.ioc.xml.factorybean.StudentFactory;
import com.javaapi.test.spring.spring.ioc.xml.factorybean.WorkerI;


public class TeacherImp implements WorkerI {
	private String name;
	private StudentFactory student;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void work() {
		System.out.println("上课");
	}

	public StudentFactory getStudent() {
		return student;
	}

	public void setStudent(StudentFactory studentFactory) {
		this.student = studentFactory;
	}

}
