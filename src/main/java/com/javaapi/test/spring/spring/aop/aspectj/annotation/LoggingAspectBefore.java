package com.javaapi.test.spring.spring.aop.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectBefore {
	@Before("execution(* com.javaapi.test.spring.spring.aop.aspectj.annotation.CustomerBo.addCustomer(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println(LoggingAspectBefore.class.getSimpleName()+ "==>before");
	}

}