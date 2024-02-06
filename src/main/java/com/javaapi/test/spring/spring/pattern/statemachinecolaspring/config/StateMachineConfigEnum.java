package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.state.GuaranteeState;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@SuppressWarnings("all")
@Slf4j
public enum StateMachineConfigEnum {
    /**
     * 保单
     */
    GUARANTEE("guarantee", GuaranteeState.class,GuaranteeState.class,GuaranteeEvent.class),
    ;
    private final String machineName;
    private final Class from;
    private final Class to;
    private final Class event;

    StateMachineConfigEnum(String machineName, Class from, Class to, Class event) {
        this.machineName = machineName;
        this.from = from;
        this.to = to;
        this.event = event;
    }
    
    public static StateMachineConfigEnum getByMachineName(String name){
        for (StateMachineConfigEnum value : StateMachineConfigEnum.values()) {
            if (value.getMachineName().equals(name)) {
                return value;
            }
        }
        log.error("暂不支持该业务逻辑:{}",name);
        throw new IllegalStateException("暂不支持该业务逻辑");
    }
}
