package com.javaapi.test.spring.spring.pattern.templatev2.factory.exception;

import com.javaapi.test.spring.spring.pattern.template.error.AbstractErrorFactory;
import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 *
 */
public class BaseException extends com.javaapi.test.spring.spring.pattern.template.exception.BaseException {

    private static final long serialVersionUID = -8280129889986059779L;

    /**
     * 全链路上下文ID
     */
    private String traceId;
    /**
     * error信息描述
     */
    private String errorMsg;

    /**
     * @param error
     * @param cause
     */
    public BaseException(BaseError error, Throwable cause) {
        super(error, cause);
    }

    /**
     * @param error
     * @param cause
     */
    public BaseException(String traceId, BaseError error, Throwable cause) {
        super(error, cause);
        this.traceId = traceId;
    }

    /**
     * @param error
     */
    public BaseException(String traceId, BaseError error) {
        super(error);
        this.traceId = traceId;
    }

    /**
     * @param error
     */
    public BaseException(BaseError error) {
        super(error);
    }

    public BaseException(BaseError error, String errorMsg) {
        super(error);
        this.errorMsg = errorMsg;
    }

    /**
     * @param cause
     */
    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(Throwable cause, String errorMsg) {
        super(cause);
        this.errorMsg = errorMsg;
    }

    /**
     * @param cause
     */
    public BaseException(String traceId, Throwable cause) {
        super(cause);
        setError(AbstractErrorFactory.createStaticError(cause.getMessage(), "LY600001"));
        this.traceId = traceId;
    }

    public BaseException(String traceId, Throwable cause, String errorMsg) {
        super(cause);
        setError(AbstractErrorFactory.createStaticError(cause.getMessage(), "LY600001"));
        this.traceId = traceId;
        this.errorMsg = errorMsg;
    }

    /**
     * Getter method for property <tt>traceId</tt>.
     *
     * @return property value of traceId
     */
    public String getTraceId() {
        return traceId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
