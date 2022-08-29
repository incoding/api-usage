package com.javaapi.test.spring.spring.pattern.templatev2.factory.filter;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.GatewayFilterContext;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.FilterException;

import java.io.Serializable;

/**
 * The interface gateway filter.
 */
public interface GatewayFilter<Req extends Serializable, Res extends Serializable> extends Comparable<GatewayFilter<Req, Res>> {
    /**
     * GatewayFilter
     * Should filter boolean.
     *
     * @return the boolean
     */
    boolean shouldFilter(GatewayFilterContext<Req, Res> context);

    /**
     * Execute filter logic
     *
     * @return the object
     */
    Object filter(GatewayFilterContext<Req, Res> context) throws FilterException;

    /**
     * The filter type
     * <p>
     * Sub-class should provides the filter type
     *
     * @return the filter type
     */
    String filterType();

    /**
     * Filter order
     * <p>
     * Sub-class should provides the filter order
     *
     * @return the filter order
     */
    int filterOrder();
}
