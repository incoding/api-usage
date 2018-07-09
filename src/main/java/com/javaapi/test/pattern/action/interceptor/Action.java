package com.javaapi.test.pattern.action.interceptor;

public class Action {

	public Object invoke() {
		System.out.println("执行主要方法");
		return "主要方法得返回值";
	}

}
