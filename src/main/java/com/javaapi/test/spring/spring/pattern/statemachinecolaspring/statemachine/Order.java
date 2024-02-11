package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

import org.springframework.core.Ordered;

import java.lang.annotation.*;





@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@org.springframework.core.annotation.Order
@Inherited
public @interface Order {
    /**
     * The order value.
     * <p>Default is {@link Ordered#LOWEST_PRECEDENCE}.
     * @see Ordered#getOrder()
     */
    int value() default Ordered.LOWEST_PRECEDENCE;

}