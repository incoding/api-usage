package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;


import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.*;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.P03CheckingToCancelTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.P02CheckingToPayWaitTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.P01InitToCheckingTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.nonesense.PayWaitToPayWaitTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.sms.context.SmsContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Ignore;
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
        GuaranteeResult result = null;
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
        GuaranteeCreateContext context = new GuaranteeCreateContext();
        GuaranteeCreateResult result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        Assert.assertEquals(P01InitToCheckingTransit.class.toString(), context.getThroughTransit());
        log.info("end:{}", result);
        GuaranteeCreateContext contextSecond = new GuaranteeCreateContext();
        result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", contextSecond);
        Assert.assertEquals(P01InitToCheckingTransit.class.toString(), contextSecond.getThroughTransit());
        log.info("end:{}", result);
    }

    /**
     * 分别俩次调用状态机,源状态和事件不同看是否有影响
     */
    @Test
    public void testFireTwiceDiff() {
        log.info("start");
        GuaranteeCreateContext context = new GuaranteeCreateContext();
        GuaranteeCreateResult result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        Assert.assertEquals(P01InitToCheckingTransit.class.toString(), context.getThroughTransit());
        log.info("end:{}", result);
        GuaranteeCheckRefuseContext contextSecond = new GuaranteeCheckRefuseContext();
        GuaranteeCheckRefuseResult resultRefuse = stateMachineProxy.fire("guarantee", "CHECKING", "CHECK_REFUSE", contextSecond);
        Assert.assertEquals(P03CheckingToCancelTransit.class.toString(), contextSecond.getThroughTransit());
        log.info("end:{}", resultRefuse);
    }

    /**
     * 多个状态机,分别调用一次
     */
    @Test
    public void testFireOtherStateMachine() {
        log.info("start");
        GuaranteeCreateResult result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", new GuaranteeCreateContext());
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
        GuaranteeCreateContext context = new GuaranteeCreateContext();
        context.setId(GuaranteeContext.RUNTIME_EXCEPTION_ID);
        GuaranteeCreateResult result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        } catch (Exception e) {
            Assert.assertEquals(RuntimeException.class, e.getClass());
            Assert.assertEquals(P01InitToCheckingTransit.class.toString(), context.getThroughTransit());
        }
        log.info("end:{}", result);
    }

    /**
     * Exception 异常
     */
    @Test
    public void testFireException() {
        log.info("start");
        GuaranteeCreateContext context = new GuaranteeCreateContext();
        context.setId(GuaranteeContext.EXCEPTION_ID);
        GuaranteeCreateResult result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        } catch (Exception e) {
            Assert.assertEquals(UnsupportedEncodingException.class, e.getClass());
            Assert.assertEquals(P01InitToCheckingTransit.class.toString(), context.getThroughTransit());
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
        GuaranteeCheckPassContext context = new GuaranteeCheckPassContext();
        context.setConditionResult(false);
        GuaranteeCheckPassResult result = null;
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
        GuaranteeCheckRefuseContext context = new GuaranteeCheckRefuseContext();
        context.setId(3L);
        GuaranteeCheckRefuseResult result = null;
        try {
            result = stateMachineProxy.fire("guarantee", "CHECKING", "CHECK_REFUSE", context);
        } catch (Exception e) {
            Assert.assertEquals(RuntimeException.class, e.getClass());
            Assert.assertEquals(P03CheckingToCancelTransit.class.toString(), context.getThroughTransit());
        }
        log.info("end:{}", result);
    }

    /**
     * 原状态和事件构成一个流转
     * 多个流转的规则如下:
     * 1 同一个源状态,多个不同事件? 算不同流转,不同transit 不会覆盖
     * 2 同一个源状态,相同事件定义多次? 也算不同流转, 就是一个state不同transit,不会覆盖, transit选择优先级如下
     *  2.1 选择所有含执行条件的transit中按构建顺序遍历后符合条件的第一个transit: 只会选择满足一个condition 条件的执行 ,参考 CheckingToChecking2lTransit,CheckingToCheckinglTransit,CheckingToPayWaitTransit的关系
     *  2.2 选择所有无条件的transit中最后一个构建的transit
     * 3 不同源状态,同一个事件 ?算不同流转,不同transit 不会覆盖
     * 4 流转与目标状态相同,在状态机构建阶段就会出异常, 参考 CheckingToChecking3lTransit,CheckingToPayWaitTransit 的关系
     */
    @Test
    public void testFireMultiplyTransit() {
        log.info("start");
        GuaranteeCheckPassContext context = new GuaranteeCheckPassContext();
        context.setId(3L);
        context.setConditionResult(true);
        GuaranteeCheckPassResult result;
        result = stateMachineProxy.fire("guarantee", "CHECKING", "CHECK_PASS", context);
        Assert.assertEquals(P02CheckingToPayWaitTransit.class.toString(), context.getThroughTransit());
        log.info("end:{}", result);
    }

    /**
     * 源状态与目标状态相同,但是事件不同.
     * 基本只跟源状态和事件有关,目标状态无所谓.
     */
    @Test
    public void testSameFromToStateTransit() {
        testFireMultiplyTransit();
    }

    /**
     * 内部transit:
     * 内部transit目前无特殊效果,同外部transit一样
     */
    @Test
    public void testInnerTransit(){
        testFireMultiplyTransit();
    }

    /**
     * 子类重新定义有transit注解,按子类transit注解.
     * 子类无transit 注解.取父类注解
     * 参考 CheckingToCheckinglTransit,CheckingToChecking2lTransit
     *
     */
    @Test
    public void testTransitInherited() {
        testFireMultiplyTransit();
    }

    /** 可控制构建顺序,因为构建顺序略微影响同一流程下多个transit最终选择
     *  目前支持spring order 注解,order value 越小优先级越高
     */
    @Test
    public void testOrder(){
        testFireMultiplyTransit();
    }

    /**
     * 避免顺序认知混乱,全部要提供condition方法.
     * CheckingToChecking2lTransit,CheckingToCheckinglTransit
     *
     */
    @Test
    @Ignore
    public void testIgnoreCondition(){
    }

    /**
     * 目前源状态目标状态一致,事件不一样是支持的
     * 要支持内部转换的原始目的是什么? 状态转换后的稳定态还重复过来之前的事件
     */
    @Test
    public void testSameFromToTransit(){
        log.info("start");
        GuaranteeContext context = new GuaranteeContext();
        Object result;
        result = stateMachineProxy.fire("guarantee", "PAY_WAIT", "CHECK_PASS", context);
        Assert.assertEquals(PayWaitToPayWaitTransit.class.toString(), context.getThroughTransit());
        log.info("end:{}", result);
    }

    /**
     *     //TODO 如何支持连续状态转换
     *  连续状态转换?->考虑 内部继续调用状态机
     */
    @Test
    public void testContinusTransit(){
    }

    //TODO 测试嵌套异常,就是会不会spring框架包装了个什么异常,无法获取原始异常
    //TODO context是否要改名?
    //TODO fire 是否需要支持泛型?
    //TODO serviceInvoker 拆分? 或者itransit 接口改名为serviceInvoker?
}