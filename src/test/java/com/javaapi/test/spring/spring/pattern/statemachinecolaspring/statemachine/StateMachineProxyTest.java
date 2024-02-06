package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;


import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit.CheckingToCancelTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit.InitToCheckingTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.sms.context.SmsContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

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
        Object result = null;
        try {
            result = stateMachineProxy.fire("xxx", "INIT", "CREATE", context);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
        }
        log.info("end:{}", result);
    }

    /**
     * 传未知状态是不支持的
     */
    @Test
    public void testFireUnknownState() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "XXX", "CREATE", context);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
        }
        log.info("end:{}", result);
    }


    /**
     * 传未知事件是不支持的
     */
    @Test
    public void testFireUnknownEvent() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "INIT", "XXX", context);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), IllegalArgumentException.class);
        }
        log.info("end:{}", result);
    }

    /**
     * 传未定义过的当前状态和事件组合
     */
    @Test
    public void testFireUndefineTransit() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "INIT", "CHECK_PASS", context);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), UnsupportedOperationException.class);
        }
        log.info("end:{}", result);
    }

    /**
     * 传未定义过的当前状态和事件组合
     */
    @Test
    public void testFireTwiceSame() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        Assert.assertEquals(InitToCheckingTransit.class.toString(), context.getThroughTransit());
        log.info("end:{}", result);
        GuaranteeContext contextSecond = new GuaranteeContext();
        result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", contextSecond);
        Assert.assertEquals(InitToCheckingTransit.class.toString(), contextSecond.getThroughTransit());
        log.info("end:{}", result);
    }

    /**
     * 传未定义过的当前状态和事件组合
     */
    @Test
    public void testFireTwiceDiff() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        Assert.assertEquals(InitToCheckingTransit.class.toString(), context.getThroughTransit());
        log.info("end:{}", result);
        GuaranteeContext contextSecond = new GuaranteeContext();
        result = stateMachineProxy.fire("guarantee", "CHECKING", "CHECK_REFUSE", contextSecond);
        Assert.assertEquals(CheckingToCancelTransit.class.toString(), contextSecond.getThroughTransit());
        log.info("end:{}", result);
    }

    /**
     * 多个状态机,分表调用一次
     */
    @Test
    public void testFireOtherStateMachine() {
        log.info("start");
        Object result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", new GuaranteeContext());
        log.info("end:{}", result);
        result = stateMachineProxy.fire("sms", "INIT", "SEND", new SmsContext());
        log.info("end:{}", result);
    }

    /**
     * RuntimeException 异常
     */
    @Test
    public void testFireRuntimeException() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        context.setId(GuaranteeContext.RUNTIME_EXCEPTION_ID);
        Object result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), RuntimeException.class);
            Assert.assertEquals(InitToCheckingTransit.class.toString(), context.getThroughTransit());
        }
        log.info("end:{}", result);
    }

    /**
     * Exception 异常
     */
    @Test
    public void testFireException() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        context.setId(GuaranteeContext.EXCEPTION_ID);
        Object result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        } catch (Exception e) {
            Assert.assertEquals(e.getClass(), UnsupportedEncodingException.class);
            Assert.assertEquals(InitToCheckingTransit.class.toString(), context.getThroughTransit());
        }
        log.info("end:{}", result);
    }

    //TODO 嵌套异常
    //TODO 条件校验
    //TODO 省略条件

}