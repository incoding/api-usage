
package com.javaapi.test.spring.spring.pattern.template.exception;

import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 * 系统root异常，所有业务异常应继承该异常
 */
public class TradeException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 全链路上下文ID
     */
    private String traceId;

    /**
     * @param error
     * @param cause
     */
    public TradeException(String traceId, BaseError error, Throwable cause) {
        super(error, cause);
        this.traceId = traceId;
    }

    /**
     * @param error
     */
    public TradeException(String traceId, BaseError error) {
        super(error);
        this.traceId = traceId;
    }

    /**
     * @param cause
     */
    public TradeException(String traceId, Throwable cause) {
        super(cause);
        this.traceId = traceId;
    }

    /**
     * Getter method for property <tt>traceId</tt>.
     *
     * @return property value of traceId
     */
    public String getTraceId() {
        return traceId;
    }

}
