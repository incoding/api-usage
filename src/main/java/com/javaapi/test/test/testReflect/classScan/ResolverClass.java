package com.javaapi.test.test.testReflect.classScan;

import com.javaapi.test.test.testReflect.classScan.annotation.Resolver;

/**
 * Created by user on 2018/11/19
 */
public class ResolverClass {

    @Resolver(name="nameResolver")
    public String resolveName(String name,String name2){
        return name + name2;
    }
}
