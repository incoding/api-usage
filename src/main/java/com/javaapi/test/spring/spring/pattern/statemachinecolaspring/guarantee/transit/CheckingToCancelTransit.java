package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.service.GuaranteeServiceImpl;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.state.GuaranteeState;
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
public class CheckingToCancelTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeContext> {

    @Resource
    private GuaranteeServiceImpl guaranteeServiceImpl;

    @Override
    public boolean condition(GuaranteeContext context) {
        return true;
    }

    @Override
    public void execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
        guaranteeServiceImpl.cancelOrder(context.getId());
    }

}
