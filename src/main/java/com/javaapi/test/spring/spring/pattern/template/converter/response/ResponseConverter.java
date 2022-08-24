package com.javaapi.test.spring.spring.pattern.template.converter.response;

import java.io.Serializable;

/**
 * @author zss48204
 * @version Id : RequestConvertor, v 0.1 2019/08/18 22:58 zss48204 Exp $
 */
public interface ResponseConverter<Response extends Serializable, InnerResponse extends Serializable> {

    /**
     * @param response
     * @return
     */
    Response converter(InnerResponse response);
}