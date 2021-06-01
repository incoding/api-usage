package com.javaapi.test.projects.statemachinesquirrel.annotation;

import com.javaapi.test.projects.statemachinesquirrel.MyContext;
import com.javaapi.test.projects.statemachinesquirrel.MyEvent;
import com.javaapi.test.projects.statemachinesquirrel.MyState;
import org.junit.Test;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;

/**
 * Created by user on 2021/5/31.
 * 支持注解
 */
public class Client {
    @Test
    public void test2() {
        StateMachineBuilder<MyStateMachine, MyState, MyEvent, MyContext> builder =
                StateMachineBuilderFactory.create(MyStateMachine.class, MyState.class, MyEvent.class, MyContext.class);


        MyStateMachine machine = builder.newStateMachine(MyState.A);
        machine.addDeclarativeListener(machine.new DeclarativeListener());
        machine.start();
        System.out.println("currentState is " + machine.getCurrentState());
        MyContext context = new MyContext();
        context.setNum(20);
        machine.fire(MyEvent.ToB, context);
        System.out.println("currentState is " + machine.getCurrentState());
    }
}
