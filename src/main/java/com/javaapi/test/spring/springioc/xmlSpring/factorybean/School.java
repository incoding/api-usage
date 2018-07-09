package com.javaapi.test.spring.springioc.xmlSpring.factorybean;


public class School {
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
