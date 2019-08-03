package com.javaapi.test.spring.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class PersonAfterReturningAdvice implements AfterReturningAdvice {  
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {  
        System.out.println("AfterReturningAdvice：方法调用后");  
    }  
}  