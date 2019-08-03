package com.javaapi.test.buisness.pattern.action.interceptor;

public class LogInterceptor implements Interceptor {

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("before");
		invocation.invoke();
		System.out.println("after");
		return null;
	}

	@Override
	public void destroy() {
	}

}
