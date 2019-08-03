package com.javaapi.test.spring.spring.ioc.annotation.xmlMix;

import org.springframework.beans.factory.annotation.Autowired;

public class School {
	@Autowired
	public WorkerI teacher;


    public String resource;

	public WorkerI getTeacher() {
		return teacher;
	}

	public void setTeacher(WorkerI teacher) {
		this.teacher = teacher;
	}
	public void haveClass(){
		teacher.work();
	}
}
