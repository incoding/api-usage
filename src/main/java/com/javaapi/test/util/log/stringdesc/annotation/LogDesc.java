package com.javaapi.test.util.log.stringdesc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by user on 2021/4/1.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogDesc {

    String name() default "unknown";

    enum Type {
        STRING, ENUM, DATE, LONG, INTEGER
    }

    Type type() default LogDesc.Type.STRING;

    int order() default 0;

}
