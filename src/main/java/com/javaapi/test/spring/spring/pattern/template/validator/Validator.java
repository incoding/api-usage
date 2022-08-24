
package com.javaapi.test.spring.spring.pattern.template.validator;


import com.javaapi.test.spring.spring.pattern.template.exception.ValidationException;

import java.io.Serializable;

/**
 * API请求参数校验接口
 */
public interface Validator<Request extends Serializable> {

    /**
     * 参数校验方法
     *
     * @param request 请求
     * @throws ValidationException 异常
     */
    void validate(Request request) throws ValidationException;
}

