package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

public interface IStateTransit<S,E,C> {

    boolean condition(C context);

    void execute(S from, S to, E event, C context);
}
