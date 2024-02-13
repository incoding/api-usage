package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.facade;

import lombok.Data;

@Data
public class FireVO {
    private Long id;
    private String traceId;
    private String sourceState;
}
