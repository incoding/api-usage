package com.javaapi.test.businessdesign.howtoextend.extendGeneric.servicedelegate;

import com.javaapi.test.businessdesign.howtoextend.extendGeneric.BookValidateException;
import com.javaapi.test.businessdesign.howtoextend.extendGeneric.ValidationContext;

/**
 * Created by user on 2019/12/1
 */

public interface ServiceDelegator<Response> {
    /**
     * 强校验服务外部接口调用代理
     *
     * @param context
     * @return
     * @throws BookValidateException
     */
    Response invoke(ValidationContext context) throws BookValidateException;

}