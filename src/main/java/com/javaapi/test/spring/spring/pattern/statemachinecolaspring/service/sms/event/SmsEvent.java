package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.sms.event;

import lombok.Getter;

@Getter
public enum SmsEvent {
    SEND,
    SEND_SUCCESS,
    SEND_FAIL,
    ;

}
