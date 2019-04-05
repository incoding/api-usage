package com.javaapi.test.util.opensource.reflect.reflections;

import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.io.BufferedReader;
import java.util.Set;

/**
 * Created by user on 18/4/4
 */
public class Client {
    /**
     * getSubTypesOf
     */
    @Test
    public void test(){
        Reflections reflections = new Reflections("com.javaapi.test.testUtil.opensource.reflect.reflections");
        Set<Class<? extends People>> subTypesOf = reflections.getSubTypesOf(People.class);
        System.out.println("subTypesOf = " + subTypesOf);
    }


    /**
     * 注意 new SubTypesScanner(false) 得使用
     * @throws Exception
     */
    @Test
    public void getAllTypes() throws Exception {
        Reflections reflections = new Reflections("com.javaapi.test.testUtil.opensource.reflect.reflections",new SubTypesScanner(false));
        Set<String> allTypes = reflections.getAllTypes();
        System.out.println("allTypes = " + allTypes);
    }

    /**
     * 遇到不是类的会报错 (比如说xml ,jar  会报错)
     * @throws Exception
     */
    @Test
    public void getAllType() throws Exception {
        Reflections reflections = new Reflections("com.javaapi.test.testUtil",new SubTypesScanner(false));
        Set<String> allTypes = reflections.getAllTypes();
        System.out.println("allTypes = " + allTypes);
    }

    @Test
    public void getInstance() throws Exception {
        Reflections reflections = new Reflections("com.javaapi.test.testUtil.opensource.reflect.reflections",new SubTypesScanner(false));
        Set<String> allTypes = reflections.getAllTypes();
        for (String allType : allTypes) {
            Class<?> classType = Class.forName(allType);
        }
    }
}
