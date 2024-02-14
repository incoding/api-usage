package com.javaapi.test.spring.spring.pattern.statemachinecolacup.instance;

import com.javaapi.test.spring.spring.pattern.statemachinecolacup.TransitExecutor;
import org.springframework.stereotype.Component;

/**
 * 流转执行器
 */
@Component
public class GuaranteeTransitExecutorImpl implements TransitExecutor<MyCreateContext, MyCreateResult> {

    @Override
    public MyCreateResult execute(MyCreateContext myCreateContext) {
        System.out.println("myGuaranteeCreateContext.getFrom() = " + myCreateContext.getFrom());
        System.out.println("myGuaranteeCreateContext.getTo() = " + myCreateContext.getTo());
        System.out.println("myGuaranteeCreateContext.getEvent() = " + myCreateContext.getEvent());
        MyCreateResult myCreateResult = new MyCreateResult();
        myCreateResult.setResult(true);
        return myCreateResult;
    }
}
