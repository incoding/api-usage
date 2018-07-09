package com.javaapi.test.appframework.readWriteSeparate.annotation;

import java.lang.annotation.*;

/**
 * 根据注解选择数据源,默认走主库
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Datasource {
    String value() default "master";
}
