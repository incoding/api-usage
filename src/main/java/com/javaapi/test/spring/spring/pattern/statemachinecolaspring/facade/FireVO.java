package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.facade;

import lombok.Data;

@Data
public class FireVO {
    private Long id;
    private String traceId;
    /**
     * 业务
     */
    private String biz;
    /**
     * 事件
     */
    private String event;
    /**
     * 临时测试用不是长期使用
     */
    private transient String sourceState;
}
