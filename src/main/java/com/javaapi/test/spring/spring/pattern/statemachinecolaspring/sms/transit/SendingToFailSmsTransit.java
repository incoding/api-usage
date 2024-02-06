package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.sms.transit;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.sms.context.SmsContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.sms.event.SmsEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.sms.state.SmsState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.IStateTransit;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.Transit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @see  SmsState
 */
@Transit(machine = StateMachineConfigEnum.SMS,from = "SENDING",to = "FAIL", event = "SEND_FAIL")
@Component
@Slf4j
public class SendingToFailSmsTransit implements IStateTransit<SmsState, SmsEvent, SmsContext> {

    @Override
    public boolean condition(SmsContext context) {
        return true;
    }

    @Override
    public void execute(SmsState from, SmsState to, SmsEvent event, SmsContext context) {
        log.info("通过:{}",this.getClass());
        context.setThroughTransit(this.getClass().toString());
    }

}
