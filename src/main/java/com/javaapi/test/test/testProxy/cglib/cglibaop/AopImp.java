package com.javaapi.test.test.testProxy.cglib.cglibaop;

public class AopImp implements Aop {

	@Override
	public void before() {
		System.out.println("aop before ==>"+AopImp.class.getSimpleName());
	}

	@Override
	public void after() {
		System.out.println("aop after ==>"+AopImp.class.getSimpleName());
	}

}
