package com.javaapi.test.spring.springioc.annotationSpring.annotationSample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
	@Autowired
	public WorkerI teacher;

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
