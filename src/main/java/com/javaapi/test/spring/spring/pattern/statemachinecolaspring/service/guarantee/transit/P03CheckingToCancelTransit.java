package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCheckRefuseContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCheckRefuseResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.service.GuaranteeServiceImpl;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "CHECKING", to = "CANCEL", event = "CHECK_REFUSE")
@Component
@Slf4j
public class P03CheckingToCancelTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeCheckRefuseContext, GuaranteeCheckRefuseResult> {

    @Resource
    private GuaranteeServiceImpl guaranteeServiceImpl;

    @Override
    public boolean condition(GuaranteeCheckRefuseContext context) {
        log.info("通过条件:{}",this.getClass());
        return true;
    }


    @Override
    public GuaranteeCheckRefuseResult execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeCheckRefuseContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
        guaranteeServiceImpl.check(false, context.getId());
        return new GuaranteeCheckRefuseResult(this.getClass().toString());
    }

}
