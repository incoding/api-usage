package com.javaapi.test.spring.zotherFeature.SpringInitOrder;

public class F implements IF {
	F() {
		System.out.println("执行F的构造函数");
	}

	public void funcOfF() {
		System.out.println("执行F的函数");
	}
}