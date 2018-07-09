package com.javaapi.test.spring.aop.aspectj.xml2;

import org.aspectj.lang.JoinPoint;

public class LoggingAspectBefore {
 
	public void logBefore(JoinPoint joinPoint) {
		System.out.println(LoggingAspectBefore.class.getSimpleName()+"==>before");
	}
 
}