package com.javaapi.test.test.reflect.genericType;

import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.List;

/**
 * http://www.jianshu.com/p/e8eeff12c306
 */
public class ClientTypeVariable<T extends Number & Serializable & Comparable> {
    private List<T> list;

    private T t;

    /**
     * 1 先获取 TypeVariable
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void getActualTypeArguments() throws NoSuchFieldException {
        Field fieldList = ClientTypeVariable.class.getDeclaredField("list");
        Type genericType = fieldList.getGenericType();
        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println("actualTypeArgument = " + actualTypeArgument.getClass().getName());
        }

    }


    /**
     * 获得该类型变量的上限，也就是泛型中extend右边的值；例如 List<T extends Number> ，Number就是类型变量T的上限；
     * 如果我们只是简单的声明了List<T>（无显式定义extends），那么默认为Object；
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void getBounds() throws NoSuchFieldException {
        Field fieldList = ClientTypeVariable.class.getDeclaredField("t");
        Type genericType = fieldList.getGenericType();
        System.out.println("genericType = " + genericType.getClass().getName());
        TypeVariable typeVariable = (TypeVariable) genericType;
        Type[] bounds = typeVariable.getBounds();
        // Number Serializable Comparable
        for (Type bound : bounds) {
            System.out.println(bound);
        }

    }


    /**
     *获取声明该类型变量实体，也就是TypeVariableTest<T>中的TypeVariableTest；
     *
     * 说到TypeVariable类，就不得不提及Java-Type体系中另一个比较重要的接口---GenericDeclaration；含义为：声明类型变量的所有实体的公共接口；也就是说该接口定义了哪些地方可以定义类型变量（泛型）；

     通过查看源码发现，GenericDeclaration下有三个子类，分别为Class、Method、Constructor；也就是说，我们定义泛型只能在一个类中这3个地方自定义泛型；
     */
    @Test
    public void getGenericDeclaration() throws NoSuchFieldException {
        Field fieldList = ClientTypeVariable.class.getDeclaredField("t");
        Type genericType = fieldList.getGenericType();
        TypeVariable typeVariable = (TypeVariable) genericType;
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        System.out.println("genericDeclaration = " + genericDeclaration);
    }


    /**
     *获取声明该类型变量实体，也就是TypeVariableTest<T>中的TypeVariableTest；
     */
    @Test
    public void getName() throws NoSuchFieldException {
        Field fieldList = ClientTypeVariable.class.getDeclaredField("t");
        Type genericType = fieldList.getGenericType();
        TypeVariable typeVariable = (TypeVariable) genericType;
        String genericDeclaration = typeVariable.getName();
        System.out.println("genericDeclaration = " + genericDeclaration);
    }

}
