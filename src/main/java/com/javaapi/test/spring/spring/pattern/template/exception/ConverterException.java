
package com.javaapi.test.spring.spring.pattern.template.exception;

import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 * API模型转换器
 */
public class ConverterException extends BaseException {

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
    public ConverterException(BaseError error, Throwable cause) {
        super(error, cause);
    }

    /**
     * @param error
     */
    public ConverterException(BaseError error) {
        super(error);
    }

    /**
     * @param cause
     */
    public ConverterException(Throwable cause) {
        super(cause);
    }

    /**
     * @param error
     * @param cause
     */
    public ConverterException(String traceId, BaseError error, Throwable cause) {
        super(error, cause);
        this.traceId = traceId;
    }

    /**
     * @param error
     */
    public ConverterException(String traceId, BaseError error) {
        super(error);
        this.traceId = traceId;
    }

    /**
     * @param cause
     */
    public ConverterException(String traceId, Throwable cause) {
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
