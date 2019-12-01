package com.javaapi.test.businessdesign.howtoextend.extendGenericPractice;

import com.javaapi.test.businessdesign.howtoextend.extendGeneric.BookValidateException;
import com.javaapi.test.businessdesign.howtoextend.extendGeneric.ValidationContext;
import com.javaapi.test.businessdesign.howtoextend.extendGeneric.servicedelegate.ServiceDelegator;

/**
 * Created by user on 2019/12/1
 */
public class ServiceDelegatorImpl2 implements ServiceDelegator<DelegatorResult2> {

    @Override
    public DelegatorResult2 invoke(ValidationContext context) throws BookValidateException {
        System.out.println("ServiceDelegatorImpl2 invoke ");
        return null;
    }
}
