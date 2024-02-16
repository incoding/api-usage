package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteePaySuccessContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteePaySuccessResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "PAY_WAIT", to = "COMPLETE", event = "PAY_SUCCESS")
@Component
@Slf4j
public class PayWaitToCompleteTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteePaySuccessContext, GuaranteePaySuccessResult> {

    @Override
    public boolean condition(GuaranteePaySuccessContext context) {
        log.info("通过条件:{}",this.getClass());
        return true;
    }

    @Override
    public GuaranteePaySuccessResult execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteePaySuccessContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
        return new GuaranteePaySuccessResult(this.getClass().toString());
    }

}
