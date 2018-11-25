package com.javaapi.test.spring.ioc.genericIoc;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by user on 2018/11/25
 */
public class BasicService<T> {

    @Autowired
    protected BasicRepository<T> basicRepository;

    public void add()
    {
        System.out.println("BasicService<T> add...");
        System.out.println(basicRepository);
        basicRepository.save();
    }
}