package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCheckPassContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCheckPassResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.service.GuaranteeServiceImpl;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "CHECKING", to = "PAY_WAIT", event = "CHECK_PASS")
@Component
@Slf4j
@Order(-2)
public class P02CheckingToPayWaitTransit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeCheckPassContext, GuaranteeCheckPassResult> {

    @Resource
    private GuaranteeServiceImpl guaranteeServiceImpl;

    @Override
    public boolean condition(GuaranteeCheckPassContext context) {
        boolean conditionResult = BooleanUtils.isTrue(context.getConditionResult());
        if (conditionResult) {
            log.info("通过条件:{}",this.getClass());
        }
        return conditionResult;
    }

    @Override
    public GuaranteeCheckPassResult execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeCheckPassContext context) {
        log.info("通过:{}",this.getClass());
        guaranteeServiceImpl.check(true, context.getId());
        context.setThroughTransit(this.getClass().toString());
        return new GuaranteeCheckPassResult(this.getClass().toString());
    }

}
