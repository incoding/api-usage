package com.javaapi.test.spring.spring.pattern.statemachinecolacup.instance;

import com.javaapi.test.spring.spring.pattern.statemachinecolacup.TransitInfoListener;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state.GuaranteeState;
import lombok.Data;

@Data
public class GuaranteeCreateContext implements TransitInfoListener<GuaranteeState, GuaranteeEvent> {

    private GuaranteeState from;
    private GuaranteeEvent event;
    private GuaranteeState to;

}
