package com.javaapi.test.projects.statemachinesquirrel.annotation2;

/**
 * Created by user on 2021/5/31.
 */

import com.javaapi.test.projects.statemachinesquirrel.MyContext;
import com.javaapi.test.projects.statemachinesquirrel.MyEvent;
import com.javaapi.test.projects.statemachinesquirrel.MyState;
import org.squirrelframework.foundation.exception.TransitionException;
import org.squirrelframework.foundation.fsm.Action;
import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

/**
 * 定义我的状态机：需继承AbstractStateMachine
 */
@States({
        @State(name = "A", entryCallMethod = "entryStateA", exitCallMethod = "exitStateA"),
        @State(name = "B", entryCallMethod = "entryStateB", exitCallMethod = "exitStateB")
})
@Transitions({
        @Transit(from = "A", to = "B", on = "ToB", callMethod = "fun1"),
        @Transit(from = "A", to = "B", on = "ToB"),
})
public class MyStateMachine extends AbstractStateMachine<MyStateMachine, MyState, MyEvent, MyContext> {

    public void fun1(MyState from, MyState to, MyEvent event, MyContext context) {

        System.out.println("fun1() 方法执行了。。。。。。。。。。。。。 from：" + from + ", to:" + to + ", event:" + event + ", context:" + context.num);
    }

    public void entryStateA(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("entryStateA");
    }

    public void exitStateA(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("exitStateA");
    }

    public void entryStateB(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("entryStateB");
    }

    public void exitStateB(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("exitStateB");
    }


    /**
     * 约定大于配置
     * like：
     * transitFrom[fromStateName]To[toStateName]On[eventName]When[conditionName]
     * transitFrom[fromStateName]To[toStateName]On[eventName]
     * transitFromAnyTo[toStateName]On[eventName]
     * transitFrom[fromStateName]ToAnyOn[eventName]
     * transitFrom[fromStateName]To[toStateName]
     * on[eventName]
     */
    protected void transitFromAToBOnToB(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("从A--->B执行....约定大于配置");
    }

    /**
     * exitA执行
     */
    protected void exitA(MyState from, MyState to, MyEvent event, MyContext context) {
        System.out.println("exitA()方法执行了。。。。。。。。");
    }


    public class DeclarativeListener {

        @OnTransitionBegin
        public void transitionBegin(MyEvent event) {
            // method annotated with TransitionBegin will be invoked when transition begin...
            System.out.println("转换开始执行.." + event);
        }

        /**
         * 条件：context.num == 20 || event.name().equals("toC")
         */
        @OnTransitionBegin(when = "context.num == 20 || event.name().equals(\"toC\")")
        public void begins(MyState from, MyState to, MyEvent event, MyContext context) {
            System.out.println("begins 执行了， from：" + from + ", to:" + to + ", event:" + event + ", context:" + context.num);
        }

        @OnTransitionEnd
        @ListenerOrder(10) // Since 0.3.1 ListenerOrder can be used to insure listener invoked orderly
        public void transitionEnd() {
            // method annotated with TransitionEnd will be invoked when transition end...
            // the method must be public and return nothing
            System.out.println("转换结束执行..");
        }

        @OnTransitionComplete
        public void transitionComplete(String from, String to, MyEvent event, Integer context) {
            // method annotated with TransitionComplete will be invoked when transition complete...
            System.out.println("转换成功执行..");
        }

        @OnTransitionDecline
        public void transitionDeclined(String from, MyEvent event, Integer context) {
            // method annotated with TransitionDecline will be invoked when transition declined...
            System.out.println("转换拒绝执行..");
        }

        @OnBeforeActionExecuted
        public void onBeforeActionExecuted(Object sourceState, Object targetState,
                                           Object event, Object context, int[] mOfN, Action<?, ?, ?, ?> action) {
            // method annotated with OnAfterActionExecuted will be invoked before action invoked
            System.out.println("状态机内方法动作执行之前...111111111111111111111111111111111");
        }

        @OnAfterActionExecuted
        public void onAfterActionExecuted(Object sourceState, Object targetState,
                                          Object event, Object context, int[] mOfN, Action<?, ?, ?, ?> action) {
            // method annotated with OnAfterActionExecuted will be invoked after action invoked
            System.out.println("状态机内方法动作执行之后...222222222222222222222222222222222");
        }

        @OnActionExecException
        public void onActionExecException(Action<?, ?, ?, ?> action, TransitionException e) {
            // method annotated with OnActionExecException will be invoked when action thrown exception
            System.out.println("转换异常执行。。");
        }

    }

}
