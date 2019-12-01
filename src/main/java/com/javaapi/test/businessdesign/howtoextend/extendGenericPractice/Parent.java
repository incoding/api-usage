package com.javaapi.test.businessdesign.howtoextend.extendGenericPractice;


import com.javaapi.test.businessdesign.howtoextend.extendGeneric.BookValidateException;
import com.javaapi.test.businessdesign.howtoextend.extendGeneric.ValidationContext;
import com.javaapi.test.businessdesign.howtoextend.extendGeneric.servicedelegate.ServiceDelegator;

/**
 * Created by user on 2019/12/1
 */
public abstract class Parent<Response> {

    public String invoke() {
        try {
            getServiceDelegator().invoke(new ValidationContext());
        } catch (BookValidateException e) {
            e.printStackTrace();
        }
        System.out.println("parent");
        return "";
    }

    protected abstract ServiceDelegator<Response> getServiceDelegator();
}
