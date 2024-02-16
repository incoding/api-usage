package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context;

import lombok.Data;

@Data
public class GuaranteeCheckPassContext {
    public static Long RUNTIME_EXCEPTION_ID = 1L;
    public static Long EXCEPTION_ID = 2L;
    private String throughTransit;
    private Boolean conditionResult;
    private Long id;
}
