package com.javaapi.test.test.reflect.sample.stringdesc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogDesc {

    String name() default "unknown";

    int order() default 0;

}
