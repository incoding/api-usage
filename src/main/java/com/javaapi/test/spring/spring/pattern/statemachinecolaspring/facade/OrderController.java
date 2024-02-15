package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.facade;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.context.GuaranteeCreateContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.StateMachineProxy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Component
public class OrderController {
    @Resource
    private StateMachineProxy stateMachineProxy;




    /**
     * 支持泛化调用
     */
    @RequestMapping("fire")
    public Object fire(FireVO fireVO){
        String sourceState = getSourceState(fireVO);
        fireVO.setSourceState(sourceState);
        return stateMachineProxy.fire(fireVO);
    }

    public Object fireCreate(GuaranteeCreateContext context) {
        String sourceState = "INIT";
        return stateMachineProxy.fire("guarantee",sourceState,"CREATE", context);
    }

    private String getSourceState(FireVO fireVO) {
        //获取不到订单就是默认INIT
        return StringUtils.defaultString(fireVO.getSourceState(), "INIT");
    }
}
