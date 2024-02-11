package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;


import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit.CheckingToCancelTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit.CheckingToPayWaitTransit;
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
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
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
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
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
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
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
            Assert.assertEquals(UnsupportedOperationException.class, e.getClass());
        }
        log.info("end:{}", result);
    }

    /**
     * 分别俩次调用状态机,源状态和事件相同看是否有影响
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
     * 分别俩次调用状态机,源状态和事件不同看是否有影响
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
     * 多个状态机,分别调用一次
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
            Assert.assertEquals(RuntimeException.class, e.getClass());
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
            Assert.assertEquals(UnsupportedEncodingException.class, e.getClass());
            Assert.assertEquals(InitToCheckingTransit.class.toString(), context.getThroughTransit());
        }
        log.info("end:{}", result);
    }

    /**
     * condition 返回为false,不会走execute
     * 返回值与未定义transit 表现一致
     */
    @Test
    public void testFireConditionFalse() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        context.setConditionResult(false);
        Object result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "CHECKING", "CHECK_PASS", context);
        } catch (Exception e) {
            Assert.assertEquals(UnsupportedOperationException.class, e.getClass());
            Assert.assertNotNull(null, context.getThroughTransit());
        }
        log.info("end:{}", result);
    }

    /**
     * service异常
     */
    @Test
    public void testFireServiceException() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        context.setId(3L);
        Object result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "CHECKING", "CHECK_REFUSE", context);
        } catch (Exception e) {
            Assert.assertEquals(RuntimeException.class, e.getClass());
            Assert.assertEquals(CheckingToCancelTransit.class.toString(), context.getThroughTransit());
        }
        log.info("end:{}", result);
    }

    /**
     * 原状态和事件构成一个流转
     * 多个流转的规则如下:
     * 1 同一个源状态,多个不同事件? 算不同流转,不同transit 不会覆盖
     * 2 同一个源状态,相同事件定义多次? 也算不同流转, 就是一个state不同transit,不会覆盖,
     *  2.1 如果是相同源状态相同事件中都没有条件,就用最后一个
     *  2.2 如果是相同源状态相同事件中有条件,则只选第一个符合的条件的. 没有符合条件的.就只选无条件的最后一个, 但只会选择满足一个condition 条件的执行 ,参考 CheckingToChecking2lTransit,CheckingToCheckinglTransit,CheckingToPayWaitTransit的关系
     * 3 不同源状态,同一个事件 ?算不同流转,不同transit 不会覆盖
     * 4 流转与目标状态相同,在状态机构建阶段就会出异常, 参考 CheckingToChecking3lTransit,CheckingToPayWaitTransit 的关系
     */
    @Test
    public void testFireMultiplyTransit() {
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        context.setId(3L);
        context.setConditionResult(true);
        Object result;
        result = stateMachineProxy.fire("guarantee", "CHECKING", "CHECK_PASS", context);
        Assert.assertEquals(CheckingToPayWaitTransit.class.toString(), context.getThroughTransit());
        log.info("end:{}", result);
    }

    /**
     * 源状态与目标状态相同,但是事件不同.  基本只跟源状态和事件有关,目标状态无所谓.
     */
    @Test
    public void testSameFromToStateTransit() {
        testFireMultiplyTransit();
    }

    //TODO 嵌套异常
    //TODO 可省略条件校验
    //TODO 支持内部转换?,目前不支持内部转换
    //TODO 子类重新定义有transit注解,子类无transit 注解 ?

}