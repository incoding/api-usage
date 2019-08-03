package com.javaapi.test.spring.spring.aop.springaop1ProxyFactoryBean1;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
public class CommonInteceptor extends PerformanceMonitorInterceptor {

	private static final long	serialVersionUID	= 1L;

	@Override
	protected Object invokeUnderTrace(MethodInvocation invocation, Log logger)
			throws Throwable {
		String name = createInvocationTraceName(invocation);
		StopWatch stopWatch = new StopWatch(name);
		stopWatch.start(name);
		try {
			return invocation.proceed();
		} finally {
			stopWatch.stop();
			System.out.println(stopWatch.shortSummary());
		}
	}

}