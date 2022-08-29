package com.javaapi.test.spring.spring.pattern.templatev2.factory.annotation;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.GatewayMethodEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务网关标注
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Gateway {
    GatewayMethodEnum value();
}
