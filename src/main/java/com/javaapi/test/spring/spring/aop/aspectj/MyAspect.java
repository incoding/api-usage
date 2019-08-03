package com.javaapi.test.spring.spring.aop.aspectj;


import org.aspectj.lang.JoinPoint;

/**
 * 自定义的切面
 * @author Cabriel
 *
 */
public class MyAspect {
	public void doBefore(JoinPoint jp){
		System.out.println("log begin method: "+jp.getTarget().getClass().getName()+"."+jp.getSignature().getName());
	}
	
	public void doAfter(JoinPoint jp){
		System.out.println("log end method: "+jp.getTarget().getClass().getName()+"."+jp.getSignature().getName());
	}
}