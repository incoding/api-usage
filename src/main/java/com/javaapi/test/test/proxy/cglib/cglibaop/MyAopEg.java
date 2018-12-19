package com.javaapi.test.test.proxy.cglib.cglibaop;

public class MyAopEg implements Aop {

	@Override
	public void before() {
		System.out.println("aop before ==>"+MyAopEg.class.getSimpleName());

	}
	@Override
	public void after() {
		System.out.println("aop after ==>"+MyAopEg.class.getSimpleName());
	}

}
