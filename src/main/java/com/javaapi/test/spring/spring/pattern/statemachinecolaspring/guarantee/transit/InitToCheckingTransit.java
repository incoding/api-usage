package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "INIT", to = "CHECKING", event = "CREATE")
@Component
@Slf4j
public class InitToCheckingTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeContext> {

    @Override
    public boolean condition(GuaranteeContext context) {
        return true;
    }

    @Override
    @SneakyThrows
    public void execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
        if (GuaranteeContext.RUNTIME_EXCEPTION_ID.equals(context.getId())) {
            log.info("内部RuntimeException异常");
            throw new RuntimeException("内部RuntimeException异常");
        }
        if (GuaranteeContext.EXCEPTION_ID.equals(context.getId())) {
            log.info("内部UnsupportedEncodingException异常");
            throw new UnsupportedEncodingException("内部UnsupportedEncodingException异常");
        }
    }

}