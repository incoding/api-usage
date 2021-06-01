package com.javaapi.test.spring.spring.pattern.statemachinesquirrel;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.GenericTypeResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.StateMachineConfiguration;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;

/**
 * Created by user on 2021/6/1.
 */
public class AbstractStateMachineEngine<T extends UntypedStateMachine> implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    protected UntypedStateMachineBuilder stateMachineBuilder = null;

    @SuppressWarnings("unchecked")
    public AbstractStateMachineEngine() {
        //识别泛型参数
        Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(),
                AbstractStateMachineEngine.class);
        stateMachineBuilder = StateMachineBuilderFactory.create(genericType, ApplicationContext.class);
    }

    //注入applicationContext，并在创建StateMachine实例时注入
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public boolean fire(DeviceEvent event, DeviceContext context) {
        // 加锁
        T stateMachine = stateMachineBuilder.newUntypedStateMachine(
                context.getModel().getStatus(),
                //暂时开启debug进行日志trace
                StateMachineConfiguration.create().enableDebugMode(true).enableAutoStart(true),
                //注入applicationContext
                applicationContext);

        // 添加监听器
//        stateMachine.addStateMachineListener(new StateMachineListener<UntypedStateMachine, Object, Object, Object>() {
//            @Override
//            public void stateMachineEvent(StateMachineEvent<UntypedStateMachine, Object, Object, Object> event) {
//                log.info("lastState: " + event.getStateMachine().getLastState());
//            }
//        });
//        stateMachine.addDeclarativeListener(new DeclarativeEventListener());
        // 源码中的日志 demo
//        StateMachineLogger logger = new StateMachineLogger(stateMachine);
//        logger.startLogging();

        //由于StateMachine实例不是由Spring容器创建，所以这个过程中无法通过注解方式开启事务(Spring没有机会去创建事务代理)，因此采用了编程式事务
        DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) applicationContext.getBean("transactionManager");
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            stateMachine.fire(event, context);
            transactionManager.commit(status);
            //这里会返回状态机是否出错，如果出错可用于通知Controller层
            return stateMachine.isError();
        } catch (Exception ex) {
            //用于事务回滚
            transactionManager.rollback(status);
            return true;
        }
        // 释放锁
    }
}