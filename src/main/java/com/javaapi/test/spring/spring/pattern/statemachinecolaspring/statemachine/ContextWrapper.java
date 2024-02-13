package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

import lombok.Data;

@Data
public class ContextWrapper<C,R> {
    private C context;
    private R result;
}
