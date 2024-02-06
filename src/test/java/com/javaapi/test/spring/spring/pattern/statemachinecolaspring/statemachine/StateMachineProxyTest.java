package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;


import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.context.GuaranteeContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by user on 2020/12/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Slf4j
public class StateMachineProxyTest {

    @Resource
    StateMachineProxy stateMachineProxy;

    /**
     * 传未知状态机名字
     */
    @Test
    public void testFireUnknownMachineName() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = stateMachineProxy.fire("xxx", "INIT", "CREATE", context);
        log.info("end"+result);
    }

    /**
     * 传未知状态是不支持的
     */
    @Test
    public void testFireUnknownState() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = stateMachineProxy.fire("guarantee", "XXX", "CREATE", context);
        log.info("end"+result);
    }


    /**
     * 传未知事件是不支持的
     */
    @Test
    public void testFireUnknownEvent() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = stateMachineProxy.fire("guarantee", "INIT", "XXX", context);
        log.info("end"+result);
    }

    /**
     * 传未定义过的当前状态和事件组合
     */
    @Test
    public void testFireUndefineTransit() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = stateMachineProxy.fire("guarantee", "INIT", "CHECK_PASS", context);
        log.info("end"+result);
    }

    /**
     * 多个状态机
     */
    @Test
    public void testFireOtherStateMachine() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = stateMachineProxy.fire("guarantee", "INIT", "CHECK_PASS", context);
        log.info("end"+result);
        result = stateMachineProxy.fire("sms", "INIT", "CHECK_PASS", context);
        log.info("end"+result);

    }

    /**
     * 成功
     */
    @Test
    public void testFireSuccess() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        log.info("end"+result);
    }


}