package com.javaapi.test.spring.spring.custom.custombeanload.customcommon;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 Created by user on 2019/5/4
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyComponent {
}
