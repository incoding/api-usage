package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

public interface IStateTransit<S,E,C,R> {

    boolean condition(C context);

    R execute(S from, S to, E event, C context);
}
