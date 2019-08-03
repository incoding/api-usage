package com.javaapi.test.spring.spring.feature.function.init;

public class F implements IF {
	F() {
		System.out.println("执行F的构造函数");
	}

	public void funcOfF() {
		System.out.println("执行F的函数");
	}
}