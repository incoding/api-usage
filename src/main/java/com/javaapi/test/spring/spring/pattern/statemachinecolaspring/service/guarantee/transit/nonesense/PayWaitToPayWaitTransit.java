package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.nonesense;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "PAY_WAIT", to = "PAY_WAIT", event = "CHECK_PASS")
@Component
@Slf4j
public class PayWaitToPayWaitTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeContext,GuaranteeResult> {

    @Override
    public boolean condition(GuaranteeContext context) {
        log.info("通过条件:{}",this.getClass());
        return true;
    }

    @Override
    public GuaranteeResult execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
        return new GuaranteeResult(this.getClass().toString());
    }

}
