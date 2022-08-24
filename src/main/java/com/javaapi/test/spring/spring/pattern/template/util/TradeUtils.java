
package com.javaapi.test.spring.spring.pattern.template.util;

import com.javaapi.test.spring.spring.pattern.template.core.TradeService;
import com.javaapi.test.spring.spring.pattern.template.core.TradeServiceEnum;
import com.javaapi.test.spring.spring.pattern.template.enums.OrderSourceEnum;
import com.javaapi.test.spring.spring.pattern.template.enums.ResourceTypeEnum;


/**
 *
 */
public class TradeUtils {

    /**
     *
     */
    private TradeUtils() {
    }

    /**
     * 获取TradeService注解唯一标识: serviceName_channel
     *
     * @param tradeService
     * @return
     */
    public static String resolveTradeServiceId(TradeService tradeService) {
        if (tradeService == null) {
            throw new IllegalArgumentException("TradeService is null");
        }
        return tradeService.name().getCode() + "_" + tradeService.resourceType().getCode() + "_" + tradeService.source().name();
    }

    /**
     * 获取TradeService注解唯一标识: serviceName_channel
     *
     * @param service
     * @param serviceResourceType
     * @return
     */
    public static String resolveTradeServiceId(TradeServiceEnum service, ResourceTypeEnum serviceResourceType, OrderSourceEnum source) {
        if (service == null) {
            throw new IllegalArgumentException("TradeServiceEnum is null");
        }
        return service.getCode() + "_" + serviceResourceType.getCode() + "_" + source.name();
    }

}
