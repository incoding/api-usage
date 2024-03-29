package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCreateContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCreateResult;
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
public class GuaranteeStateMachineTest {

    @Resource
    StateMachineProxy stateMachineProxy;

    /**
     * 成功
     */
    @Test
    public void testFireSuccess() {
        log.info("start");
        GuaranteeCreateContext context = new GuaranteeCreateContext();
        GuaranteeCreateResult result = stateMachineProxy.fire("guarantee", "INIT", "CREATE", context);
        log.info("end"+result);
    }

}
