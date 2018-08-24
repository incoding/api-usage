package com.javaapi.test.spring.ioc.annotation.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
	static{
		System.out.println(School.class.getSimpleName());
	}
	{
		System.out.println(School.class.getSimpleName()+"实例初始化块");
	}
	@Autowired
	public WorkerI teacher;
	public School(){
		System.out.println(School.class.getSimpleName()+"构造函数");
		System.out.println(this);
	}
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
