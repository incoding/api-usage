package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.state;

import lombok.Getter;

@Getter
public enum GuaranteeState {
    INIT,
    CHECKING,
    CANCEL,
    PAY_WAIT,
    COMPLETE,
}
