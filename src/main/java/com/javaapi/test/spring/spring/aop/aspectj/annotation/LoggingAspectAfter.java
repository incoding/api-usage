package com.javaapi.test.spring.spring.aop.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectAfter {
	@After("execution(* com.javaapi.test.spring.spring.aop.aspectj.annotation.CustomerBo.addCustomer(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println(LoggingAspectAfter.class.getSimpleName()+"==>after");
	}
 
}