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
            Enum fromEnum = this.getEnum(from, stateMacheConfigEnum.getFrom());
            Enum toEnum = this.getEnum(to, stateMacheConfigEnum.getTo());
            Enum eventEnum = this.getEnum(event, stateMacheConfigEnum.getEvent());
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
        Enum fromEnum = this.getEnum(sourceState, machineConfig.getFrom());
        Enum eventEnum = this.getEnum(event, machineConfig.getEvent());
        Object resultState = stateMachine.fireEvent(fromEnum, eventEnum, context);
        if (resultState.equals(fromEnum)){
         /* 2种情况
            1 未定义状态支持的事件
            2 用户重试状态已变更
            */
            log.warn("状态转换未定义,machineName:{},sourceState:{},event:{}",machineName,sourceState,event);
            throw new UnsupportedOperationException("状态已变更");
        }
        return resultState;
    }

    private Enum getEnum(String name, Class clazz) {
        Enum anEnum;
        try {
            anEnum = Enum.valueOf(clazz, name);
        } catch (Exception e) {
            log.info("业务暂时不支持,name:{},class:{}",name,clazz);
            throw new IllegalArgumentException("操作暂不支持",e);
        }
        return anEnum;
    }
}
