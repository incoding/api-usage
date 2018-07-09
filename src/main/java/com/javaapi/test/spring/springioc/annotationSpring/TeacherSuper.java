package com.javaapi.test.spring.springioc.annotationSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherSuper {
	@Autowired
	TeacherSuperDependI superDepend;
	static{
		System.out.println(TeacherSuper.class.getSimpleName());
	}
	{
		System.out.println(TeacherSuper.class.getSimpleName()+"实例初始化块");
	}
	public TeacherSuper(){
		System.out.println(TeacherSuper.class.getSimpleName()+"构造函数");
		System.out.println(this);
	}
	
	public void say() {

	}
}
