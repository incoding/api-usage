package com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalMany;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnSystemPropertyCondition.class)
public @interface KKConditionalOnSystemProperty {
    public String value();
    public boolean exists() default true;
}