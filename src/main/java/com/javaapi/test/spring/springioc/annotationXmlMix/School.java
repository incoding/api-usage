package com.javaapi.test.spring.springioc.annotationXmlMix;

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
