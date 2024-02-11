package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit.nonesense;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit.CheckingToPayWaitTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 内部转换  checking to checking
 *
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "CHECKING", to = "CHECKING", event = "CHECK_PASS")
@Component
@Slf4j
public class CheckingToCheckinglTransit extends CheckingToPayWaitTransit {

    @Override
    public boolean condition(GuaranteeContext context) {
        return true;
    }

    @Override
    public void execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeContext context) {
        // 重复调用check_
        log.info("通过:{}", this.getClass());
    }

}
