package com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalMany;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class HardCodedSystemPropertyPresentCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return (System.getProperty("servicedefault_1") != null);
    }
}