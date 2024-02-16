package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.cola.statemachine.Action;
import com.alibaba.cola.statemachine.Condition;
import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.builder.StateMachineBuilder;
import com.alibaba.cola.statemachine.builder.StateMachineBuilderFactory;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.config.StateMachineConfigEnum;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.facade.FireVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
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
     * transit持有的类型引用
     */
    private final static Map<String, Map<String, Type>> transitClassGeneric = Maps.newHashMap();

    /**
     * 初始化所有状态机
     */
    @PostConstruct
    public void init(){
        Map<String, Object> beansWithAnnotation = SpringUtil.getApplicationContext().getBeansWithAnnotation(Transit.class);
        Map<StateMachineConfigEnum, List<IStateTransit>> stateMachineGroup = this.getStateMachineGroup(beansWithAnnotation);
        for (StateMachineConfigEnum config : stateMachineGroup.keySet()) {
            // 状态机和对应的
            List<IStateTransit> iStateTransits = stateMachineGroup.get(config);
            AnnotationAwareOrderComparator.sort(iStateTransits);
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
            String fromStr = transit.from();
            String toStr = transit.to();
            String eventStr = transit.event();
            Enum fromEnum = StateMachineUtils.getEnum(fromStr, stateMacheConfigEnum.getFrom());
            Enum toEnum = StateMachineUtils.getEnum(toStr, stateMacheConfigEnum.getTo());
            Enum eventEnum = StateMachineUtils.getEnum(eventStr, stateMacheConfigEnum.getEvent());

            Condition<ContextWrapper> conditonWrapper = (ContextWrapper context) -> {
                Object param;
                if (context.isGenericInvoke()) {
                    param = JSON.parseObject((String) context.getContext(), transitClassGeneric.get(iStateTransit.getClass().getName()).get(StateMachineConstant.CONTEXT));
                }else{
                    param = context.getContext();
                }
                return iStateTransit.condition(param);
            };
            Action<?,?,ContextWrapper> actionWrapper = (from1, to1, event1, context) -> {
                if (from1.equals(to1)) {
                    context.setSameFromToPassed(true);
                }
                Object param;
                if (context.isGenericInvoke()) {
                    param = JSON.parseObject((String) context.getContext(), transitClassGeneric.get(iStateTransit.getClass().getName()).get(StateMachineConstant.CONTEXT));
                }else{
                    param = context.getContext();
                }
                Object execute = iStateTransit.execute(from1, to1, event1, param);
                context.setResult(execute);
            };
            builder.externalTransition()
                   .from(fromEnum)
                   .to(toEnum)
                   .on(eventEnum)
                   .when(conditonWrapper)
                   .perform(actionWrapper);
        }
        return builder.build(stateMacheConfigEnum.getMachineName());
    }

    /**
     * 每个状态机一组状态转换
     */
    private Map<StateMachineConfigEnum, List<IStateTransit>> getStateMachineGroup(Map<String, Object> beansWithAnnotation) {
        Map<StateMachineConfigEnum, List<IStateTransit>> result = new HashMap<>();
        for (Object value : beansWithAnnotation.values()) {
            Transit transit = value.getClass().getAnnotation(Transit.class);
            if (transit == null) {
                continue;
            }
            if (value instanceof IStateTransit) {
                // 初始化transit的分组信息,是属于哪个状态机组
                this.initTransitGroup((IStateTransit) value, transit, result);
                // 初始化transit 实现类的类型信息
                this.initTransitType((IStateTransit) value);
            }
        }
        return result;
    }

    /**
     * 初始化transit 实现类的类型信息
     */
    private void initTransitType(IStateTransit value) {
        // 写入类型信息
        Class<?> aClass = value.getClass();
        ParameterizedTypeImpl itransitGeneric = getItransitGeneric(aClass);
        if (itransitGeneric == null) {
            return;
        }
        Map<String, Type> keyToType = Maps.newHashMap();
        keyToType.put(StateMachineConstant.STATE, (itransitGeneric).getActualTypeArguments()[0]);
        keyToType.put(StateMachineConstant.EVENT, (itransitGeneric).getActualTypeArguments()[1]);
        keyToType.put(StateMachineConstant.CONTEXT, (itransitGeneric).getActualTypeArguments()[2]);
        keyToType.put(StateMachineConstant.RESULT, (itransitGeneric).getActualTypeArguments()[3]);
        transitClassGeneric.put(value.getClass().getName(), keyToType);
    }

    /**
     * 获取 IStateTransit 接口所有的泛型信息
     */
    private  ParameterizedTypeImpl getItransitGeneric(Class clazz) {
        Class temp = clazz;
        while (!temp.equals(Object.class)){
            Type[] genericInterfaces = temp.getGenericInterfaces();
            for (Type genericInterface : genericInterfaces) {
                ParameterizedTypeImpl parameterizedType = (ParameterizedTypeImpl) genericInterface;
                if (parameterizedType.getRawType().getName().equals(IStateTransit.class.getName())) {
                    return parameterizedType;
                }
            }
            temp = temp.getSuperclass();
        }
        return null;
    }


    /**
     * 初始化transit的分组信息,是属于哪个状态机组
     */
    private void initTransitGroup(IStateTransit iStateTransit, Transit transit, Map<StateMachineConfigEnum, List<IStateTransit>> result) {
        // 分组放入
        List<IStateTransit> nameToTransit = result.computeIfAbsent(transit.machine(),(k)-> Lists.newArrayList());
        nameToTransit.add(iStateTransit);
    }

    /**
     * 状态机触发
     * @param machineName 状态机名字
     * @param sourceState 源状态
     * @param event 事件
     * @param context 上下文
     * @return 转换后的状态
     */
    public <C,R> R fire(String machineName,String sourceState,String event,C context){
        return this.fire(machineName, sourceState, event, context, false);
    }

    /**
     * 状态机触发
     * @param machineName 状态机名字
     * @param sourceState 源状态
     * @param event 事件
     * @param context 上下文
     * @return 转换后的状态
     */
    public <C,R> R fire(String machineName,String sourceState,String event,C context,boolean genericInvoke){
        StateMachine stateMachine = stateMachineMap.get(machineName);
        if (stateMachine == null ){
            log.error("业务暂不支持,machine:{},sourceState:{},event:{},context:{}",machineName,sourceState,event,context);
            throw new IllegalArgumentException("业务暂不支持");
        }
        StateMachineConfigEnum machineConfig = StateMachineConfigEnum.getByMachineName(machineName);
        Enum fromEnum = StateMachineUtils.getEnum(sourceState, machineConfig.getFrom());
        Enum eventEnum = StateMachineUtils.getEnum(event, machineConfig.getEvent());
        ContextWrapper<C, R> contextWrapper = new ContextWrapper<>();
        contextWrapper.setContext(context);
        contextWrapper.setGenericInvoke(genericInvoke);
        Object resultState = stateMachine.fireEvent(fromEnum, eventEnum, contextWrapper);
        this.transitExecuteCheck(machineName, sourceState, event, contextWrapper, resultState, fromEnum);
        return contextWrapper.getResult();
    }

    public Object fire(FireVO fireVO) {
        return this.fire(fireVO.getBiz(),fireVO.getSourceState(),fireVO.getEvent(),fireVO.getExt(),true);
    }

    /**
     * 执行检查
     *  内部transit,源状态和目标状态就是一样的
     *  外部transit 情况
     *      1 未定义状态转换支持的事件:case 1 状态正常已变更了,但是用户重复点击. 2 开发人员开发阶段少定义 等等
     *      2 定义的状态转换中的条件不符合: case 1 状态正常已变更了,但是用户重复点击  2 业务条件确实不匹配 等等
     */
    private void transitExecuteCheck(String machineName, String sourceState, String event, ContextWrapper contextWrapper, Object resultState, Enum fromEnum) {
        if (contextWrapper.isSameFromToPassed() ){
            // 内部transit,源状态和目标状态就是一样的
            return;
        }
        if (resultState.equals(fromEnum)){
         /* 外部transit 情况
            1 未定义状态转换支持的事件:case 1 状态正常已变更了,但是用户重复点击. 2 开发人员开发阶段少定义 等等
            2 定义的状态转换中的条件不符合: case 1 状态正常已变更了,但是用户重复点击  2 业务条件确实不匹配 等等
            */
            log.warn("状态转换未定义,machineName:{},sourceState:{},event:{}", machineName, sourceState, event);
            throw new UnsupportedOperationException("状态已变更");
        }
    }
}
