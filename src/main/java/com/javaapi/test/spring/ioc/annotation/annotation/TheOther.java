package com.javaapi.test.spring.ioc.annotation.annotation;

import org.springframework.stereotype.Component;

@Component
public class TheOther {
	static{
		System.out.println(TheOther.class.getSimpleName());
	}
	{
		System.out.println(TheOther.class.getSimpleName()+"实例初始化块");
	}
	public TheOther(){
		System.out.println(TheOther.class.getSimpleName()+"构造函数");
		System.out.println(this);
	}
}
