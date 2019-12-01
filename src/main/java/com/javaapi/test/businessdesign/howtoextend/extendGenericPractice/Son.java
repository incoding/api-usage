package com.javaapi.test.businessdesign.howtoextend.extendGenericPractice;

import com.javaapi.test.businessdesign.howtoextend.extendGeneric.servicedelegate.ServiceDelegator;

/**
 * Created by user on 2019/12/1
 */
public class Son extends Parent<DelegatorResult> {

    @Override
    protected ServiceDelegator<DelegatorResult> getServiceDelegator() {
        return new ServiceDelegatorImpl();
    }
}
