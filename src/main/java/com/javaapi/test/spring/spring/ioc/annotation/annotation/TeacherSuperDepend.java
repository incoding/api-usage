package com.javaapi.test.spring.spring.ioc.annotation.annotation;

import org.springframework.stereotype.Component;

@Component
public class TeacherSuperDepend implements TeacherSuperDependI {
	static{
		System.out.println(TeacherSuperDepend.class.getSimpleName());
	}
	{
		System.out.println(TeacherSuperDepend.class.getSimpleName()+"实例初始化块");
	}
	public TeacherSuperDepend(){
		System.out.println(TeacherSuperDepend.class.getSimpleName()+"构造函数");
		System.out.println(this);
	}
	@Override
	public void help(){
		
	}
}
