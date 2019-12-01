package com.javaapi.test.businessdesign.howtoextend.extendGenericPractice;

import com.javaapi.test.businessdesign.howtoextend.extendGeneric.BookValidateException;
import com.javaapi.test.businessdesign.howtoextend.extendGeneric.ValidationContext;
import com.javaapi.test.businessdesign.howtoextend.extendGeneric.servicedelegate.ServiceDelegator;

/**
 * Created by user on 2019/12/1
 */
public class ServiceDelegatorImpl implements ServiceDelegator<DelegatorResult> {

    @Override
    public DelegatorResult invoke(ValidationContext context) throws BookValidateException {
        System.out.println("ServiceDelegatorImpl invoke ");
        return null;
    }
}
