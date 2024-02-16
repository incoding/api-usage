package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCreateContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCreateResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
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
public class InitToCheckingTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeCreateContext, GuaranteeCreateResult> {

    @Override
    public boolean condition(GuaranteeCreateContext context) {
        log.info("通过条件:{}",this.getClass());
        return true;
    }

    @Override
    @SneakyThrows
    public GuaranteeCreateResult execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeCreateContext context) {
        log.info("通过:{}", this.getClass());
        context.setThroughTransit(this.getClass().toString());
        if (GuaranteeCreateContext.RUNTIME_EXCEPTION_ID.equals(context.getId())) {
            log.info("内部RuntimeException异常");
            throw new RuntimeException("内部RuntimeException异常");
        }
        if (GuaranteeCreateContext.EXCEPTION_ID.equals(context.getId())) {
            log.info("内部UnsupportedEncodingException异常");
            throw new UnsupportedEncodingException("内部UnsupportedEncodingException异常");
        }
        GuaranteeCreateResult guaranteeResult = new GuaranteeCreateResult(this.getClass().toString());
        guaranteeResult.setSuccess(true);
        return guaranteeResult;
    }

}
