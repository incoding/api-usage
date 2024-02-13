package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.sms.state;

import lombok.Getter;

@Getter
public enum SmsState {
    INIT,
    SENDING,
    FAIL,
    SUCCESS,
    ;
}
