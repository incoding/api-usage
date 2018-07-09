package com.javaapi.test.spring.springioc.annotationSpring;

import org.springframework.stereotype.Component;

@Component
public class TeacherDepend {
	static{
		System.out.println(TeacherDepend.class.getSimpleName());
	}
	{
		System.out.println(TeacherDepend.class.getSimpleName()+"实例初始化块");
	}
	public TeacherDepend(){
		System.out.println(TeacherDepend.class.getSimpleName()+"构造函数");
		System.out.println(this);
	}
	public void tool() {
		System.out.println();
	}
}
