package com.javaapi.test.projects.statemachinesquirrel.fluentapi;

import com.javaapi.test.projects.statemachinesquirrel.MyContext;
import com.javaapi.test.projects.statemachinesquirrel.MyEvent;
import com.javaapi.test.projects.statemachinesquirrel.MyState;
import org.junit.Test;
import org.squirrelframework.foundation.fsm.StateMachineBuilder;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;

/**
 * Created by user on 2021/5/31.
 */
public class Client {
    @Test
    public void test() {
        StateMachineBuilder<MyStateMachine, MyState, MyEvent, MyContext> builder =
                StateMachineBuilderFactory.create(MyStateMachine.class, MyState.class, MyEvent.class, MyContext.class);

        /**
         * 条件为：content.getNum 为20的时候转换，并执行fun1()方法
         */
        builder.externalTransition().from(MyState.A).to(MyState.B).on(MyEvent.ToB)
               .whenMvel("myCondition:::(context!=null && context.getNum() == 20)").callMethod("fun1");

        MyStateMachine machine = builder.newStateMachine(MyState.A);
        machine.start();
        System.out.println("currentState is " + machine.getCurrentState());
        MyContext context = new MyContext();
        context.setNum(20);
        machine.fire(MyEvent.ToB, context);
        System.out.println("currentState is " + machine.getCurrentState());
    }


    @Test
    public void test2() {
        StateMachineBuilder<MyStateMachine, MyState, MyEvent, MyContext> builder =
                StateMachineBuilderFactory.create(MyStateMachine.class, MyState.class, MyEvent.class, MyContext.class);

        /**
         * 条件为：content.getNum 为20的时候转换，并执行fun1()方法
         */
        builder.externalTransition().from(MyState.A).to(MyState.B).on(MyEvent.ToB)
               .whenMvel("myCondition:::(context!=null && context.getNum() == 20)").callMethod("fun1");
        builder.externalTransition().from(MyState.A).to(MyState.C).on(MyEvent.ToC);

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
