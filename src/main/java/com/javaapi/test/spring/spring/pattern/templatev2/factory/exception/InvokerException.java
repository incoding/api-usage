package com.javaapi.test.spring.spring.pattern.templatev2.factory.exception;


import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 *
 */
public class InvokerException extends BaseException {

    private static final long serialVersionUID = -3450930091498486705L;

    public InvokerException(BaseError error) {
        super(error);
    }

    public InvokerException(BaseError error, String errorMsg) {
        super(error, errorMsg);
    }

    public InvokerException(BaseError error, Throwable cause) {
        super(error, cause);
    }

    public InvokerException(Throwable cause) {
        super(cause);
    }
}
