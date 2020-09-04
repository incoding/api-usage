package com.javaapi.test.spring.custom.registry.customlog.handler;

import org.aspectj.lang.ProceedingJoinPoint;


public interface DataCollectHandler {


    Object collect(final ProceedingJoinPoint pjp) throws Throwable;

}
