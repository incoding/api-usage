package com.javaapi.test.spring.feature.SpringInitOrder;

public class C extends B {
	static {
		System.out.println("执行C的static块(C继承B)");
	}
	{
		System.out.println("执行C的普通初始化块");
	}

	C() {
		System.out.println("执行C的构造函数(C继承B)");
	}
}