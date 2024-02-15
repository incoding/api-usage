package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.facade;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCreateContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
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
        fireVO.setSourceState("INIT");
        Object fire = orderController.fire(fireVO);
        log.info("result is:{}", JSON.toJSONString(fire));
    }

    @Test
    public void testFireCreate() {
        log.info("start");
        Object fire = orderController.fireCreate(new GuaranteeCreateContext());
        log.info("result is:{}", JSON.toJSONString(fire));
    }

    /**
     * 审核通过
     */
    @Test
    public void testFireCheckPass() {

    }

    /**
     * 审核拒绝
     */
    @Test
    public void testFireCheckRefuse() {

    }


    /**
     * 支付超时
     */
    @Test
    public void testFirePayTimeout() {

    }


    /**
     * 支付成功
     */
    @Test
    public void testFirePaySuccess() {

    }
}