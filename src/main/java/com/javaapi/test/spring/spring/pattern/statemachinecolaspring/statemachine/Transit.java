package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;



import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;

import java.lang.annotation.*;

/**
 * 状态变迁
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Transit {
    /**
     * 用于区分是哪个状态机名字 这是自定义的
     */
    StateMachineConfigEnum machine();

    String from();

    String to();

    String event();

}
