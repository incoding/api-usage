package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.state;

import lombok.Getter;

@Getter
public enum GuaranteeState {
    INIT(0,"初始化"),
    CHECKING(1,"审核中"),
    PAY_WAIT(10,"待支付"),
    COMPLETE(20,"完成"),
    CANCEL(30,"已关闭"),
    ;


    private final int code;
    private final String desc;

    GuaranteeState(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
