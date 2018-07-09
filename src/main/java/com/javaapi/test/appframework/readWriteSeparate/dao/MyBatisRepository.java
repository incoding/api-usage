package com.javaapi.test.appframework.readWriteSeparate.dao;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisRepository {
    String value() default "";
}
