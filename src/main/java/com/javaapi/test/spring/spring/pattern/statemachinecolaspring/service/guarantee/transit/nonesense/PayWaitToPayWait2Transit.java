
package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.nonesense;

import com.javaapi.test.buisness.joint.outter.Result;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.testng.collections.Lists;

import java.util.List;

/**
 * @see GuaranteeState
 */
@Transit(machine = StateMachineConfigEnum.GUARANTEE, from = "PAY_WAIT", to = "PAY_WAIT", event = "CHECK_REFUSE")
@Component
@Slf4j
public class PayWaitToPayWait2Transit implements IStateTransit<GuaranteeState, GuaranteeEvent, GuaranteeContext, Result<List<String>>> {

    @Override
    public boolean condition(GuaranteeContext context) {
        log.info("通过条件:{}",this.getClass());
        return true;
    }

    @Override
    public Result<List<String>> execute(GuaranteeState from, GuaranteeState to, GuaranteeEvent event, GuaranteeContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
        return Result.success(Lists.newArrayList(""));
    }

}
