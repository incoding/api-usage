package com.javaapi.test.spring.spring.custom.proxydosomething.custombeanload.customscaner.frame;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Arrays;
import java.util.Set;

/**
 Created by user on 2019/5/3
 */
public class AgentScanner extends ClassPathBeanDefinitionScanner {
    public AgentScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }

    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        if (beanDefinitions.isEmpty()) {
            logger.warn("No AgentScanner was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.");
        } else {
            for (BeanDefinitionHolder holder : beanDefinitions) {
                GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();

                if (logger.isDebugEnabled()) {
                    logger.debug("Creating RestFulFactoryBean with name '" + holder.getBeanName() + "' and '" + definition.getBeanClassName() + "' agentInterface");
                }

                // AgentFactroyBean.interfaceClass = definition.getBeanClassName()
                definition.getPropertyValues().add("agentInterface", definition.getBeanClassName());
                definition.setBeanClass(AgentFactroyBean.class);

                if (logger.isDebugEnabled()) {
                    logger.debug("Enabling autowire by type for MapperFactoryBean with name '" + holder.getBeanName() + "'.");
                }
                definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
            }
        }
        return beanDefinitions;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        // 判断接口
        return (beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent());
//        // 判断注解
//        return super.isCandidateComponent(beanDefinition) && beanDefinition.getMetadata()
//                .hasAnnotation(AgentService.class.getName());

    }

    @Override
    protected boolean checkCandidate(String beanName, BeanDefinition beanDefinition) throws IllegalStateException {
        if (super.checkCandidate(beanName, beanDefinition)) {
            return true;
        } else {
            logger.warn("Skipping AgentFactoryBean with name '" + beanName + "' and '" + beanDefinition.getBeanClassName() + "' agentInterface"
                        + ". Bean already defined with the same name!");
            return false;
        }
    }
}