package com.javaapi.test.spring.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PersonAroundAdvice implements MethodInterceptor {  
    public Object invoke(MethodInvocation invocation) throws Throwable {  
        System.out.println("AroundAdvice：方法调用前");  
        //不要忘记调用invocation的proceed方法哦  
        Object result = invocation.proceed();   
        System.out.println("AroundAdvice：方法调用后");  
        return result;  
    }  
} 