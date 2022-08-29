package com.javaapi.test.spring.spring.pattern.templatev2.factory.exception;

import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 *
 */
public class FilterException extends BaseException {

    private static final long serialVersionUID = -543080652905834784L;

    public FilterException(String traceId, Throwable cause) {
        super(traceId, cause);
    }

    public FilterException(String traceId, Throwable cause, String errorMsg) {
        super(traceId, cause, errorMsg);
    }

    public FilterException(BaseError error) {
        super(error);
    }

    public FilterException(BaseError error, Throwable cause) {
        super(error, cause);
    }

    public FilterException(Throwable cause) {
        super(cause);
    }
}
