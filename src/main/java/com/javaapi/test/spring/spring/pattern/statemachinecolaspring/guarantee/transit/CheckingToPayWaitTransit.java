package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "CHECKING", to = "PAY_WAIT", event = "CHECK_PASS")
@Component
@Slf4j
@Order(-2)
public class CheckingToPayWaitTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeContext> {

    @Override
    public boolean condition(GuaranteeContext context) {
        log.info("通过条件:{}",this.getClass());
        return BooleanUtils.isTrue(context.getConditionResult());
    }

    @Override
    public void execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
    }

}
