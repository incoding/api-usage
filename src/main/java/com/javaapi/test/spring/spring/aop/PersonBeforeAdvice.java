package com.javaapi.test.spring.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class PersonBeforeAdvice implements MethodBeforeAdvice {  
    public void before(Method method, Object[] args, Object target) throws Throwable {  
        System.out.println("BeforeAdvice：方法调用前");  
    }  
}  