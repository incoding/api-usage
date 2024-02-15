package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

import lombok.Data;

/**
 * 上下文包装器
 */
@Data
public class ContextWrapper<C,R> {
    /**
     * 上下文
     */
    private C context;
    /**
     * 结果
     */
    private R result;
    /**
     * 源状态和目标状态相同
     */
    private boolean sameFromToPassed = false;

    /**
     * 是否是泛化调用
     */
    private boolean genericInvoke = false;
}
