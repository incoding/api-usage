package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import org.springframework.stereotype.Component;

/**
 * @see  GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE,from = "PAY_WAIT",to = "COMPLETE", event = "CHECK_PASS")
@Component
public class PayWaitToCompleteTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeContext> {

    @Override
    public boolean condition(GuaranteeContext context) {
        return true;
    }

    @Override
    public void execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeContext context) {
        System.out.println("this.getClass() = " + this.getClass());
    }

}
