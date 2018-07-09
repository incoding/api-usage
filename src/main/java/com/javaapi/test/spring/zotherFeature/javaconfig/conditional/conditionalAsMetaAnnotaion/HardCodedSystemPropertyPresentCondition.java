package com.javaapi.test.spring.zotherFeature.javaconfig.conditional.conditionalAsMetaAnnotaion;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class HardCodedSystemPropertyPresentCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return (System.getProperty("servicedefault") != null);
    }
}