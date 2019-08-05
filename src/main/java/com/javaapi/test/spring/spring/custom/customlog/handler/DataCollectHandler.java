package com.javaapi.test.spring.spring.custom.customlog.handler;

import org.aspectj.lang.ProceedingJoinPoint;


public interface DataCollectHandler {


    Object collect(final ProceedingJoinPoint pjp) throws Throwable;

}
