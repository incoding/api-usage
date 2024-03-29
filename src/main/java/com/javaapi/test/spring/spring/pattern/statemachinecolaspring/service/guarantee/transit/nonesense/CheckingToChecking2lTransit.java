package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.nonesense;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCheckPassContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCheckPassResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.P02CheckingToPayWaitTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 内部转换  checking to checking
 *
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "CHECKING", to = "CANCEL", event = "CHECK_PASS")
@Component
@Slf4j
@Order
public class CheckingToChecking2lTransit extends P02CheckingToPayWaitTransit {

    @Override
    public boolean condition(GuaranteeCheckPassContext context) {
        log.info("通过条件:{}",this.getClass());
        return true;
    }

    @Override
    public GuaranteeCheckPassResult execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeCheckPassContext context) {
        log.info("通过:{}", this.getClass());
        return new GuaranteeCheckPassResult(this.getClass().toString());
    }

}
