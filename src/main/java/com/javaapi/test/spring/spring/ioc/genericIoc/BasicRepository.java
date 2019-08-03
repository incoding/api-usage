package com.javaapi.test.spring.spring.ioc.genericIoc;

/**
 * Created by user on 2018/11/25
 */
public class BasicRepository<T> {

    public void save()
    {
        System.out.println("BasicRepository<T> save...");
    }
}