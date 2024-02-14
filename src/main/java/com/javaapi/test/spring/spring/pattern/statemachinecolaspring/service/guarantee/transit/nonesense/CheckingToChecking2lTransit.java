package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.nonesense;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.CheckingToPayWaitTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 内部转换  checking to checking
 *
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "CHECKING", to = "CANCEL", event = "CHECK_PASS")
@Component
@Slf4j
public class CheckingToChecking2lTransit extends CheckingToPayWaitTransit {

    @Override
    public boolean condition(GuaranteeContext context) {
        return true;
    }

    @Override
    public GuaranteeResult execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeContext context) {
        log.info("通过:{}", this.getClass());
        return new GuaranteeResult(this.getClass().toString());
    }

}
