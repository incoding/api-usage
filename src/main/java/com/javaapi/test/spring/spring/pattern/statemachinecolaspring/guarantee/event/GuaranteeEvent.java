package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.event;

import lombok.Getter;

@Getter
public enum GuaranteeEvent {
    CREATE,
    CHECK_PASS,
    CHECK_REFUSE,
    PAY_TIMEOUT,
    PAY_SUCCESS

}
