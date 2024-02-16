package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuaranteeCheckRefuseResult {
    private boolean success;
    private String throughTransit;


    public GuaranteeCheckRefuseResult(String throughTransit) {
        this.throughTransit = throughTransit;
    }
}
