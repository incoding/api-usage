package com.javaapi.test.spring.spring.custom.registry.customlog.aop;

import com.javaapi.test.spring.spring.custom.registry.customlog.handler.CollectHandlerProvider;
import com.javaapi.test.spring.spring.custom.registry.customlog.handler.DataCollectHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 2019/8/3
 */
@Aspect
public class CustomLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(CustomLogAspect.class);

    @Autowired
    private CollectHandlerProvider collectHandlerProvider;


    @Around(value = "execution(* *(..)) && @annotation(customLog)", argNames = "pjp,customLog")
    public Object doCollect(final ProceedingJoinPoint pjp, CustomLog customLog) throws Throwable {

        DataCollectHandler handler = collectHandlerProvider.queryCollectHandler(customLog);
        logger.info("select handler, handler name = {}", handler.getClass().getName());
        return handler.collect(pjp);
    }
}
