package com.javaapi.test.test.testReflect.annotation;

import java.lang.reflect.Type;

/**
 * Created by user on 16/8/3.
 */
public class People<T> implements SuperClass<T>{

    private  Class<T> clazz;

    public People() {
        //使用反射技术得到T的真实类型
        //获取当前new的对象的泛型的父类
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        System.out.println("genericSuperclass = " + genericSuperclass);
        System.out.println("genericSuperclass = " + genericSuperclass.getTypeName());
    }
    public Class<T> getClazz() {
        return clazz;
    }
}
