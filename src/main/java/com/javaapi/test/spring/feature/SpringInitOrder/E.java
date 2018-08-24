package com.javaapi.test.spring.feature.SpringInitOrder;

public class E implements IE {
	E() {
		System.out.println("执行E的构造函数");
	}

	public void funcOfE() {
		System.out.println("执行E的函数");
	}
}