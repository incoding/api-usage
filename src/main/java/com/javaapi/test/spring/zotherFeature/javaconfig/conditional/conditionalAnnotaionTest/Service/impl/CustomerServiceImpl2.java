package com.javaapi.test.spring.zotherFeature.javaconfig.conditional.conditionalAnnotaionTest.Service.impl;

import com.javaapi.test.spring.zotherFeature.javaconfig.conditional.conditionalAnnotaionTest.Service.CustomerService;

/**
 * Created by user on 16/6/5.
 */
public class CustomerServiceImpl2 implements CustomerService {
    @Override
    public void print() {
        System.out.println("system is  linux");
    }
}
