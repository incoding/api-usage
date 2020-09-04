package com.javaapi.test.spring.custom.registry.customlog.handler;

import com.javaapi.test.spring.custom.registry.customlog.enums.ChildNameEnum;
import com.javaapi.test.spring.custom.registry.customlog.enums.ServiceNameEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


@CustomLogHandler(serviceName = ServiceNameEnum.COMMON, childName = ChildNameEnum.DEFAULT)
@Component
public class DefaultDataCollectHandler implements DataCollectHandler {
    @Override
    public Object collect(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
