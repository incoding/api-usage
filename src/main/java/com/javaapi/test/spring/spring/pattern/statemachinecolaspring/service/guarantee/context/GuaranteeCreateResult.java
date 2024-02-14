package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuaranteeCreateResult {
    private boolean success;
    private String throughTransit;


    public GuaranteeCreateResult(String throughTransit) {
        this.throughTransit = throughTransit;
    }
}
