package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.event;

import lombok.Getter;

@Getter
public enum GuaranteeEvent {
    CREATE("CREATE","生成质保单"),
    CHECK_PASS("CHECK_PASS","审核通过"),
    CHECK_REFUSE("CHECK_REFUSE","审核拒绝"),
    PAY_TIMEOUT("PAY_TIMEOUT","支付超时"),
    PAY_SUCCESS("PAY_SUCCESS","支付成功"),
    ;

    private final String code;
    private final String desc;

    GuaranteeEvent(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
