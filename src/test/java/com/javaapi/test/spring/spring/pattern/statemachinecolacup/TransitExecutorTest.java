package com.javaapi.test.spring.spring.pattern.statemachinecolacup;


import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.StateMachine;
import com.google.common.collect.Maps;
import com.javaapi.test.spring.spring.pattern.statemachinecolacup.instance.GuaranteeCreateContext;
import com.javaapi.test.spring.spring.pattern.statemachinecolacup.instance.GuaranteeCreateResult;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.event.GuaranteeEvent;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.guarantee.state.GuaranteeState;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine.StateMachineUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;

@Slf4j
public class TransitExecutorTest {

    private final static Map<String, StateMachine> stateMachineMap = Maps.newHashMap();

    @Test
    public void test(){
//        action 里的context应该是个包装类
        Action<GuaranteeState, GuaranteeEvent, GuaranteeCreateContext> action = (GuaranteeState from, GuaranteeState to, GuaranteeEvent  event, GuaranteeCreateContext context)->{
                    //TODO 传参数,调用transExecutor并获取返回值
                    //TODO 包装返回值
                TransitExecutor<GuaranteeCreateContext, GuaranteeCreateResult> transitExecutor = guaranteeCreateContext -> new GuaranteeCreateResult();
            GuaranteeCreateResult execute = transitExecutor.execute(context);
        };
    }

//    public <R,S,E,C> R fire(S from,E event,C context){
//        StateMachine stateMachine = null;
//        return null;
//    }


    /**
     * 状态机触发
     * @param machineName 状态机名字
     * @param sourceState 源状态
     * @param event 事件
     * @param context 上下文
     * @return 转换后的状态
     */
    public Object fire(String machineName,String sourceState,String event,Object context){
        StateMachine stateMachine = stateMachineMap.get(machineName);
        if (stateMachine == null ){
            log.error("业务暂不支持,machine:{},sourceState:{},event:{},context:{}",machineName,sourceState,event,context);
            throw new IllegalArgumentException("业务暂不支持");
        }
        StateMachineConfigEnum machineConfig = StateMachineConfigEnum.getByMachineName(machineName);
        Enum fromEnum = StateMachineUtils.getEnum(sourceState, machineConfig.getFrom());
        Enum eventEnum = StateMachineUtils.getEnum(event, machineConfig.getEvent());
        Object resultState = stateMachine.fireEvent(fromEnum, eventEnum, context);
        // TODO context 当做父类容器,携带返回值

        if (resultState.equals(fromEnum)){
         /* 3 种情况
            1 未定义状态转换支持的事件
            2 定义的状态转换中的条件不符合
            3 状态正常已变更了,但是用户重试了之前的状态对应的事件
            4 内部事件转换 TODO 这个待定
            */
            log.warn("状态转换未定义,machineName:{},sourceState:{},event:{}",machineName,sourceState,event);
            throw new UnsupportedOperationException("状态已变更");
        }
        return resultState;
    }

    }