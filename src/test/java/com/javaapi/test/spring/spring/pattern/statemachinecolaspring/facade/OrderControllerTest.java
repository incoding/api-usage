package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.facade;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.*;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.CheckingToCancelTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.CheckingToPayWaitTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.PayWaitToCancelTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.PayWaitToCompleteTransit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
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
public class OrderControllerTest {

    @Resource
    OrderController orderController;

    /**
     * 泛化调用 创建
     */
    @Test
    public void testFireCreateGeneric() {
        log.info("start");
        FireVO fireVO = new FireVO();
        fireVO.setBiz(StateMachineConfigEnum.GUARANTEE.getMachineName());
        fireVO.setEvent(GuaranteeEvent.CREATE.name());
        GuaranteeCreateContext guaranteeCreateContext = new GuaranteeCreateContext();
        guaranteeCreateContext.setId(22L);
        fireVO.setExt(JSON.toJSONString(guaranteeCreateContext));
        fireVO.setSourceState(GuaranteeState.INIT.name());
        Object fire = orderController.fire(fireVO);
        log.info("result is:{}", JSON.toJSONString(fire));
    }

    /**
     * 审核通过
     */
    @Test
    public void testFireCheckPass() {
        log.info("start");
        GuaranteeCheckPassContext guaranteeCheckPassContext = new GuaranteeCheckPassContext();
        guaranteeCheckPassContext.setConditionResult(true);
        FireVO fireVO = new FireVO();
        fireVO.setBiz(StateMachineConfigEnum.GUARANTEE.getMachineName());
        fireVO.setEvent(GuaranteeEvent.CHECK_PASS.name());
        fireVO.setExt(JSON.toJSONString(guaranteeCheckPassContext));
        fireVO.setSourceState(GuaranteeState.CHECKING.name());
        Object fire = orderController.fire(fireVO);
        Assert.assertTrue(fire instanceof GuaranteeCheckPassResult);
        Assert.assertEquals(CheckingToPayWaitTransit.class.toString(),  ((GuaranteeCheckPassResult)fire).getThroughTransit());
        log.info("result is:{}", JSON.toJSONString(fire));
    }

    /**
     * 审核拒绝
     */
    @Test
    public void testFireCheckRefuse() {
        log.info("start");
        GuaranteeCheckPassContext guaranteeCheckPassContext = new GuaranteeCheckPassContext();
        FireVO fireVO = new FireVO();
        fireVO.setBiz(StateMachineConfigEnum.GUARANTEE.getMachineName());
        fireVO.setEvent(GuaranteeEvent.CHECK_REFUSE.name());
        fireVO.setExt(JSON.toJSONString(guaranteeCheckPassContext));
        fireVO.setSourceState(GuaranteeState.CHECKING.name());
        Object fire = orderController.fire(fireVO);
        Assert.assertTrue(fire instanceof GuaranteeCheckRefuseResult);
        Assert.assertEquals(CheckingToCancelTransit.class.toString(),  ((GuaranteeCheckRefuseResult)fire).getThroughTransit());
        log.info("result is:{}", JSON.toJSONString(fire));
    }


    /**
     * 支付超时
     */
    @Test
    public void testFirePayTimeout() {
        log.info("start");
        GuaranteeCheckPassContext guaranteeCheckPassContext = new GuaranteeCheckPassContext();
        FireVO fireVO = new FireVO();
        fireVO.setBiz(StateMachineConfigEnum.GUARANTEE.getMachineName());
        fireVO.setEvent(GuaranteeEvent.PAY_TIMEOUT.name());
        fireVO.setExt(JSON.toJSONString(guaranteeCheckPassContext));
        fireVO.setSourceState(GuaranteeState.PAY_WAIT.name());
        Object fire = orderController.fire(fireVO);
        Assert.assertTrue(fire instanceof GuaranteePayFailResult);
        Assert.assertEquals(PayWaitToCancelTransit.class.toString(),  ((GuaranteePayFailResult)fire).getThroughTransit());
        log.info("result is:{}", JSON.toJSONString(fire));
    }


    /**
     * 支付成功
     */
    @Test
    public void testFirePaySuccess() {
        log.info("start");
        GuaranteeCheckPassContext guaranteeCheckPassContext = new GuaranteeCheckPassContext();
        FireVO fireVO = new FireVO();
        fireVO.setBiz(StateMachineConfigEnum.GUARANTEE.getMachineName());
        fireVO.setEvent(GuaranteeEvent.PAY_SUCCESS.name());
        fireVO.setExt(JSON.toJSONString(guaranteeCheckPassContext));
        fireVO.setSourceState(GuaranteeState.PAY_WAIT.name());
        Object fire = orderController.fire(fireVO);
        Assert.assertTrue(fire instanceof GuaranteePaySuccessResult);
        Assert.assertEquals(PayWaitToCompleteTransit.class.toString(),  ((GuaranteePaySuccessResult)fire).getThroughTransit());
        log.info("result is:{}", JSON.toJSONString(fire));
    }
}