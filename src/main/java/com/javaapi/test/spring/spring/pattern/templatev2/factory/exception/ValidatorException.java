package com.javaapi.test.spring.spring.pattern.templatev2.factory.exception;


import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 *
 */
public class ValidatorException extends BaseException {

    private static final long serialVersionUID = 5016328372570057894L;

    public ValidatorException(BaseError error) {
        super(error);
    }

    public ValidatorException(BaseError error, String errorMsg) {
        super(error, errorMsg);
    }

    public ValidatorException(BaseError error, Throwable cause) {
        super(error, cause);
    }

    public ValidatorException(Throwable cause) {
        super(cause);
    }
}
