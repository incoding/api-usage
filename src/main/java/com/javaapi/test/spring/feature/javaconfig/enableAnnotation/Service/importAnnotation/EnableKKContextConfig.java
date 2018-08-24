package com.javaapi.test.spring.feature.javaconfig.enableAnnotation.Service.importAnnotation;

import com.javaapi.test.spring.feature.javaconfig.enableAnnotation.Service.ContextConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ContextConfig.class)
@Documented
public @interface EnableKKContextConfig {
}
