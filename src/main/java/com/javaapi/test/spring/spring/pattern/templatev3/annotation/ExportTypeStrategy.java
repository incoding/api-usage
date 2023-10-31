package com.javaapi.test.spring.spring.pattern.templatev3.annotation;

import com.javaapi.test.spring.spring.pattern.templatev3.enums.ExportTypeEnum;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface ExportTypeStrategy {
    ExportTypeEnum exportType();
}
