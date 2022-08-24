
package com.javaapi.test.spring.spring.pattern.template.core;


import com.javaapi.test.spring.spring.pattern.template.enums.OrderSourceEnum;
import com.javaapi.test.spring.spring.pattern.template.enums.ResourceTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 交易服务注解，系统根据该注解寻找服务进行路由
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TradeService {
    /**
     * 服务名称
     */
    TradeServiceEnum name();

    /**
     * 资源渠道
     */
    ResourceTypeEnum resourceType() default ResourceTypeEnum.COMMON;

    /**
     * 订单来源
     */
    OrderSourceEnum source() default OrderSourceEnum.COMMON;
}
