package com.javaapi.test.spring.custom.registry.customlog.client;

import com.javaapi.test.spring.custom.registry.customlog.enums.ChildNameEnum;
import com.javaapi.test.spring.custom.registry.customlog.enums.ServiceNameEnum;
import com.javaapi.test.spring.custom.registry.customlog.handler.CustomLogHandler;
import com.javaapi.test.spring.custom.registry.customlog.handler.DataCollectHandler;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2019/8/3
 */
@CustomLogHandler(serviceName = ServiceNameEnum.BOOK, childName = ChildNameEnum.BOOK_PRE)
@Component
public class LogInvoker implements DataCollectHandler {
    @Override
    public Object collect(ProceedingJoinPoint pjp) throws Throwable {
        Object param = pjp.getArgs()[0];
        if (!(param instanceof BookParam)) {
            return pjp.proceed();
        }
        BookParam bookParam = (BookParam) param;
        System.out.println("invoke pre" + bookParam);

        Object proceed = pjp.proceed();
        if (!(proceed instanceof BookResponse)) {
            return proceed;
        }
        BookResponse bookResponse = (BookResponse) proceed;
        System.out.println("invoke after = " + bookResponse);
        return proceed;
    }
}
