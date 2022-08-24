
package com.javaapi.test.spring.spring.pattern.template.exception;


import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 * 校验异常
 */
public class ValidationException extends BaseException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 全链路id
     */
    private String traceId;

    /**
     * @param error
     * @param cause
     */
    public ValidationException(BaseError error, Throwable cause) {
        super(error, cause);
    }

    /**
     * @param error
     */
    public ValidationException(BaseError error) {
        super(error);
    }

    /**
     * @param cause
     */
    public ValidationException(Throwable cause) {
        super(cause);
    }

    /**
     * @param error
     * @param cause
     */
    public ValidationException(String traceId, BaseError error, Throwable cause) {
        super(error, cause);
        this.traceId = traceId;
    }

    /**
     * @param error
     */
    public ValidationException(String traceId, BaseError error) {
        super(error);
        this.traceId = traceId;
    }

    /**
     * @param cause
     */
    public ValidationException(String traceId, Throwable cause) {
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
