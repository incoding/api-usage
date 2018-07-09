package com.javaapi.test.test.testProxy.cglib.cglibaop2;

import java.lang.reflect.Method;

public class MyAopTest2 extends AspectProxy{

	@Override
	public void before(Class<?> cls, Method method, Object[] params)
			throws Throwable {
		System.out.println("aop before ==>"+MyAopTest2.class.getSimpleName());
		super.before(cls, method, params);
	}

	@Override
	public void after(Class<?> cls, Method method, Object[] params,
			Object result) throws Throwable {
		System.out.println("aop after ==>"+MyAopTest2.class.getSimpleName());
		super.after(cls, method, params, result);
	}

}
