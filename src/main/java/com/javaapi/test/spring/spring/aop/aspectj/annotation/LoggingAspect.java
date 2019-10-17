package com.javaapi.test.spring.spring.aop.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * LoggingAspect==>before
 * LoggingAspect==>after
 * LoggingAspect==>afterThrowing   或者 afterReturn
 */
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.javaapi.test.spring.spring.aop.aspectj.annotation.CustomerBo.addCustomer(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(LoggingAspect.class.getSimpleName() + "==>before");
    }

    @After("execution(* com.javaapi.test.spring.spring.aop.aspectj.annotation.CustomerBo.addCustomer(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println(LoggingAspect.class.getSimpleName() + "==>after");
    }

    @AfterReturning("execution(* com.javaapi.test.spring.spring.aop.aspectj.annotation.CustomerBo.addCustomer(..))")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println(LoggingAspect.class.getSimpleName() + "==>afterReturning");
    }

    @AfterThrowing("execution(* com.javaapi.test.spring.spring.aop.aspectj.annotation.CustomerBo.addCustomer(..))")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println(LoggingAspect.class.getSimpleName() + "==>afterThrowing");
    }

}
