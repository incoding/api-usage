
package com.javaapi.test.spring.spring.pattern.template.exception;

import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 * 交易链路root异常
 */
public class TradeServiceException extends TradeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param traceId
     * @param error
     * @param cause
     */
    public TradeServiceException(String traceId, BaseError error, Throwable cause) {
        super(traceId, error, cause);
    }

    /**
     * @param traceId
     * @param error
     */
    public TradeServiceException(String traceId, BaseError error) {
        super(traceId, error);
    }

    /**
     * @param traceId
     * @param cause
     */
    public TradeServiceException(String traceId, Throwable cause) {
        super(traceId, cause);
    }

}
