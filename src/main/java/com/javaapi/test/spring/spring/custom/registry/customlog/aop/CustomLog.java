package com.javaapi.test.spring.spring.custom.registry.customlog.aop;

import com.javaapi.test.spring.spring.custom.registry.customlog.enums.ChildNameEnum;
import com.javaapi.test.spring.spring.custom.registry.customlog.enums.ServiceNameEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by user on 2019/8/3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface CustomLog {

    ServiceNameEnum serviceName();


    ChildNameEnum childName();

}
