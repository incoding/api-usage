package com.javaapi.test.util.validate.compare.diff.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogCompare {

    enum Type {
        STRING, ENUM, DATE, LONG, INTEGER
    }

    String name() default "unknown";

    Type type() default Type.STRING;

}
