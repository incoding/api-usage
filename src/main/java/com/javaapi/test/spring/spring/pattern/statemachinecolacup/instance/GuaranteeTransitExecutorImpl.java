package com.javaapi.test.spring.spring.pattern.statemachinecolacup.instance;

import com.javaapi.test.spring.spring.pattern.statemachinecolacup.TransitExecutor;
import org.springframework.stereotype.Component;

/**
 * 流转执行器
 */
@Component
public class GuaranteeTransitExecutorImpl implements TransitExecutor<GuaranteeCreateContext,GuaranteeCreateResult> {

    @Override
    public GuaranteeCreateResult execute(GuaranteeCreateContext guaranteeCreateContext) {
        System.out.println("myGuaranteeCreateContext.getFrom() = " + guaranteeCreateContext.getFrom());
        System.out.println("myGuaranteeCreateContext.getTo() = " + guaranteeCreateContext.getTo());
        System.out.println("myGuaranteeCreateContext.getEvent() = " + guaranteeCreateContext.getEvent());
        GuaranteeCreateResult guaranteeCreateResult = new GuaranteeCreateResult();
        guaranteeCreateResult.setResult(true);
        return guaranteeCreateResult;
    }
}
