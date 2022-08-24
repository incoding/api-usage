package com.javaapi.test.spring.spring.pattern.template.exception;

import com.javaapi.test.spring.spring.pattern.template.error.AbstractErrorFactory;
import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 * API模型转换器
 */
public class APIException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 全链路ID
     */
    private String traceId;

    /**
     * @param error
     * @param cause
     */
    public APIException(BaseError error, Throwable cause) {
        super(error, cause);
    }

    /**
     * @param error
     */
    public APIException(BaseError error) {
        super(error);
    }

    /**
     * @param cause
     */
    public APIException(Throwable cause) {
        super(cause);
    }

    /**
     * @param error
     * @param cause
     */
    public APIException(String traceId, BaseError error, Throwable cause) {
        super(error, cause);
        this.traceId = traceId;
    }

    /**
     * @param error
     */
    public APIException(String traceId, BaseError error) {
        super(error);
        this.traceId = traceId;
    }

    /**
     * @param cause
     */
    public APIException(String traceId, Throwable cause) {
        super(cause);
        this.traceId = traceId;
    }

    /**
     * Create APIException
     *
     * @param traceId
     * @param code
     * @param message
     * @param cause
     * @return
     */
    public static final APIException createAPIException(String traceId, String code, String message, Throwable cause) {
        BaseError error = AbstractErrorFactory.createStaticError(message, code);
        return new APIException(traceId, error, cause);
    }

    /**
     * Create APIException
     *
     * @param traceId
     * @param code
     * @param message
     * @return
     */
    public static final APIException createAPIException(String traceId, String code, String message) {
        BaseError error = AbstractErrorFactory.createStaticError(message, code);
        return new APIException(traceId, error);
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
