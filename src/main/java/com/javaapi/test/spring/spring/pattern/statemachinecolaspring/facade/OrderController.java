package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.facade;

import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.StateMachineProxy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Component
public class OrderController {
    @Resource
    private StateMachineProxy stateMachineProxy;

    @RequestMapping("fire")
    public Object fire(String biz,String event,FireVO fireVO){
        String sourceState = getSourceState(fireVO);
        return stateMachineProxy.fire(biz,sourceState,event, fireVO);
    }

    private String getSourceState(FireVO fireVO) {
        //获取不到订单就是默认INIT
        return StringUtils.defaultString(fireVO.getSourceState(), "INIT");
    }
}
