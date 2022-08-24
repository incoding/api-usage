package com.javaapi.test.spring.spring.pattern.template.converter.request;

import java.io.Serializable;

/**
 * @author zss48204
 * @version Id : RequestConvertor, v 0.1 2019/08/18 22:58 zss48204 Exp $
 */
public interface RequestConverter<Request extends Serializable, InnerRequest extends Serializable> {

    /**
     * @param request
     * @return
     */
    InnerRequest converter(Request request);
}