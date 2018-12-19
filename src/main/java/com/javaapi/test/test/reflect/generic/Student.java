package com.javaapi.test.test.reflect.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


class People<S extends Serializable> {

}

class Person<T> extends People<Integer> {

}

/**
 * http://www.tuicool.com/articles/JbyEjyJ
 *
 * @param <T>
 */
public class Student<T> extends Person<Student> {


    public static void main(String[] args) {
        Student<Integer> st = new Student<Integer>();
        Class clazz = st.getClass();
//getSuperclass()获得该类的父类
        System.out.println("getSuperclass=>" + clazz.getSuperclass());
//getGenericSuperclass()获得带有泛型的父类
//Type是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
        Type type = clazz.getGenericSuperclass();
        System.out.println("getGenericSuperclass =>" + type);
//ParameterizedType参数化类型，即泛型
        ParameterizedType p = (ParameterizedType) type;
//getActualTypeArguments获取参数化类型的数组，泛型可能有多个
        Class c = (Class) p.getActualTypeArguments()[0];
        System.out.println("getActualTypeArguments=>" + c);
    }
}