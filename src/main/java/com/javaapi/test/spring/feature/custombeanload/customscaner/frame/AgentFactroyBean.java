package com.javaapi.test.spring.feature.custombeanload.customscaner.frame;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 Created by user on 2019/5/3
 */
public class AgentFactroyBean <T> implements FactoryBean<T> {

    private Class<T> agentInterface;

    public void setAgentInterface(Class<T> agentInterface) {
        this.agentInterface = agentInterface;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() throws Exception {
        ClassLoader classLoader = agentInterface.getClassLoader();
        Class<T>[] interfaces = new Class[] { agentInterface };
        System.out.println("接口 实例化:" + agentInterface);
        return (T) Proxy.newProxyInstance(classLoader, interfaces, new AgentProxy());
    }

    @Override
    public Class<?> getObjectType() {
        return this.agentInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
