package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 底层状态代理
 */
@Component
@SuppressWarnings(value = {"rawtypes","unchecked"})
@Slf4j
public class StateMachineProxy {

    /**
     * 持有每个状态机与之状态转换列表的关系
     */
    private final static Map<String, com.alibaba.cola.statemachine.StateMachine> stateMachineMap = Maps.newHashMap();

    /**
     * 初始化所有状态机
     */
    @PostConstruct
    public void init(){
        Map<String, Object> beansWithAnnotation = SpringUtil.getApplicationContext().getBeansWithAnnotation(Transit.class);
        Map<StateMachineConfigEnum, List<IStateTransit>> stateMachineGroup = getStateMachineGroup(beansWithAnnotation);
        for (StateMachineConfigEnum config : stateMachineGroup.keySet()) {
            // 状态机和对应的
            List<IStateTransit> iStateTransits = stateMachineGroup.get(config);
            StateMachineProxy.stateMachineMap.put(config.getMachineName(),buidStateMachine(config, iStateTransits));
        }
    }

    /**
     * 构建根据业务配置逻辑构建一个底层状态机
     */
    private StateMachine buidStateMachine(StateMachineConfigEnum stateMacheConfigEnum, List<IStateTransit> iStateTransits) {
        StateMachineBuilder builder = StateMachineBuilderFactory.create();
        for (IStateTransit iStateTransit : iStateTransits) {
            Transit transit = iStateTransit.getClass().getAnnotation(Transit.class);
            String from = transit.from();
            String to = transit.to();
            String event = transit.event();
            Enum fromEnum = StateMachineUtils.getEnum(from, stateMacheConfigEnum.getFrom());
            Enum toEnum = StateMachineUtils.getEnum(to, stateMacheConfigEnum.getTo());
            Enum eventEnum = StateMachineUtils.getEnum(event, stateMacheConfigEnum.getEvent());
            builder.externalTransition()
                   .from(fromEnum)
                   .to(toEnum)
                   .on(eventEnum)
                   .when(iStateTransit::condition)
                   .perform(iStateTransit::execute);
        }
        return builder.build(stateMacheConfigEnum.getMachineName());
    }

    /**
     * 每个状态机一组状态转换
     */
    private  Map<StateMachineConfigEnum, List<IStateTransit>> getStateMachineGroup(Map<String, Object> beansWithAnnotation) {
        Map<StateMachineConfigEnum, List<IStateTransit>> result = new HashMap<>();
        for (Object value : beansWithAnnotation.values()) {
            Transit transit = value.getClass().getAnnotation(Transit.class);
            if (transit == null) {
                continue;
            }
            if (value instanceof IStateTransit) {
                IStateTransit iStateTransit = (IStateTransit) value;
                List<IStateTransit> nameToTransit = result.computeIfAbsent(transit.machine(),(k)-> Lists.newArrayList());
                nameToTransit.add(iStateTransit);
            }
        }
        return result;
    }

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
        if (resultState.equals(fromEnum)){
         /* 3 种情况
            1 未定义状态转换支持的事件
            2 定义的状态转换中的条件不符合
            3 状态正常已变更了,但是用户重试了之前的状态对应的事件
            */
            log.warn("状态转换未定义,machineName:{},sourceState:{},event:{}",machineName,sourceState,event);
            throw new UnsupportedOperationException("状态已变更");
        }
        return resultState;
    }

}
