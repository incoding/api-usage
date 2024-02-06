package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.sms.state;

import lombok.Getter;

@Getter
public enum SmsState {
    INIT,
    SENDING,
    FAIL,
    SUCCESS,
    ;
}
