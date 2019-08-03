package com.javaapi.test.spring.spring.aop.aspectj.xml2;

import org.aspectj.lang.JoinPoint;

public class LoggingAspectAfter {
 
	public void logAfter(JoinPoint joinPoint) {
		System.out.println(LoggingAspectAfter.class.getSimpleName()+"==>after");
	}
 
}