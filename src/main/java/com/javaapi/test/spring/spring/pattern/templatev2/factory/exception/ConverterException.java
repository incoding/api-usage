package com.javaapi.test.spring.spring.pattern.templatev2.factory.exception;


import com.javaapi.test.spring.spring.pattern.template.error.BaseError;

/**
 *
 */
public class ConverterException extends BaseException {
    private static final long serialVersionUID = 5583626073057206192L;

    public ConverterException(BaseError error) {
        super(error);
    }

    public ConverterException(BaseError error, Throwable cause) {
        super(error, cause);
    }

    public ConverterException(Throwable cause) {
        super(cause);
    }

    public ConverterException(Throwable cause, String errorMsg) {
        super(cause, errorMsg);
    }
}
