package com.javaapi.test.spring.spring.feature.javaconfig.conditional.conditionalMany;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnSystem2PropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes
                = metadata.getAnnotationAttributes(KKConditionalOnSystem2Property.class.getName());
        Boolean systemPropertyExistsCheck = (Boolean)attributes.get("exists");
        String systemProperty = (String)attributes.get("value");

        if ((systemPropertyExistsCheck && (System.getProperty(systemProperty) != null)) ||
                (!systemPropertyExistsCheck && (System.getProperty(systemProperty) == null))) {
            return true;
        }
        return false;
    }
}