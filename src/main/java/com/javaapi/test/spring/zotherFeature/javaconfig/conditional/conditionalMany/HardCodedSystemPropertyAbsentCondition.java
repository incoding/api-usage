package com.javaapi.test.spring.zotherFeature.javaconfig.conditional.conditionalMany;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class HardCodedSystemPropertyAbsentCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return (System.getProperty("servicedefault_2") == null);
    }
}