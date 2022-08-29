package com.javaapi.test.spring.spring.pattern.templatev2.factory.filter;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.GatewayFilterContext;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.GatewayFilterResult;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.enums.ExecutionStatus;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.FilterException;

import java.io.Serializable;

/**
 * Gateway filter to process before or after business logic
 */
public abstract class AbstractGatewayFilter<Req extends Serializable, Res extends Serializable> implements GatewayFilter<Req, Res> {

    /**
     * before filter type
     */
    public static final String FILTER_TYPE_PRE = "pre";

    /**
     * post filter type
     */
    public static final String FILTER_TYPE_POST = "post";

    /**
     * 全链路 id
     */
    private String traceId;

    @Override
    public Object filter(GatewayFilterContext<Req, Res> context) throws FilterException {
        // check the filter is enabled
        if (!isEnabled()) {
            return new GatewayFilterResult(ExecutionStatus.DISABLED);
        }

        // check the filter should be executed
        if (!shouldFilter(context)) {
            return new GatewayFilterResult(ExecutionStatus.SKIPPED);
        }

        // execute the filter logic
        try {
            Object res = doFilter(context);
            return new GatewayFilterResult(res, ExecutionStatus.SUCCESS);
        } catch (FilterException t) {
            throw new FilterException(traceId, t);
        }
    }

    /**
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(GatewayFilter<Req, Res> o) {
        return Integer.compare(filterOrder(), o.filterOrder());
    }

    /**
     * Do the detailed filter logic
     *
     * @param context
     * @return
     */
    protected abstract Object doFilter(GatewayFilterContext<Req, Res> context) throws FilterException;

    /**
     * whether enable the filter
     *
     * @return
     */
    public abstract boolean isEnabled();
}
