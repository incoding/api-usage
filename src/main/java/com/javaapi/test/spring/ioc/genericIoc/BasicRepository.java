package com.javaapi.test.spring.ioc.genericIoc;

import org.springframework.stereotype.Service;

/**
 * Created by user on 2018/11/25
 */
public class BasicRepository<T> {

    public void save()
    {
        System.out.println("BasicRepository<T> save...");
    }
}