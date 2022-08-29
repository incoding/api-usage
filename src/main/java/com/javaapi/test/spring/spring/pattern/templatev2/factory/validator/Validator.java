package com.javaapi.test.spring.spring.pattern.templatev2.factory.validator;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseRequestDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.ValidatorException;

/**
 *
 */
public interface Validator<Request extends BaseRequestDTO> {

    /**
     * 校验入参，已经前置业务逻辑
     *
     * @param request 请求参数
     * @throws ValidatorException
     */
    void validate(Request request) throws ValidatorException;

}
