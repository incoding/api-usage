package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteePayFailContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteePayFailResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "PAY_WAIT", to = "CANCEL", event = "PAY_TIMEOUT" )
@Component
@Slf4j
public class PayWaitToCancelTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteePayFailContext, GuaranteePayFailResult> {

    @Override
    public boolean condition(GuaranteePayFailContext context) {
        log.info("通过条件:{}",this.getClass());
        return true;
    }

    @Override
    public GuaranteePayFailResult execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteePayFailContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
        return new GuaranteePayFailResult(this.getClass().toString());
    }

}
