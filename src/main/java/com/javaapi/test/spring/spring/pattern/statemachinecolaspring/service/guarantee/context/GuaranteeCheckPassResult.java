package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuaranteeCheckPassResult {
    private boolean success;
    private String throughTransit;


    public GuaranteeCheckPassResult(String throughTransit) {
        this.throughTransit = throughTransit;
    }
}
