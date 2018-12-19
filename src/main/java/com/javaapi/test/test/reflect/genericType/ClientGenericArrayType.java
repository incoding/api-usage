package com.javaapi.test.test.reflect.genericType;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * http://www.jianshu.com/p/e8eeff12c306
 */
public class ClientGenericArrayType<T> {
    private T[] t;

    private List<String>[] listArray;

    /**
     * 1 针对数组的情况,先获取GenericArrayType
     * 2 再通过getGenericComponentType 获取ParameterizedType
     * @throws NoSuchFieldException
     */
    @Test
    public void genericArrayType() throws NoSuchFieldException {
        ClientGenericArrayType genericType = getType();
        System.out.println("genericType = " + genericType.getClass().getName());

    }

    /**
     * 返回泛型数组中元素的Type类型，即List<String>[] 中的 List<String>（ParameterizedTypeImpl）、T[] 中的T（TypeVariableImpl）；
     * @throws NoSuchFieldException
     */
    @Test
    public void getGenericComponentType() throws NoSuchFieldException {
        ClientGenericArrayType genericType = getType();
        System.out.println("genericType = " + genericType.getClass().getName());
        GenericArrayType type = (GenericArrayType) genericType;
        Type genericComponentType = type.getGenericComponentType();
        System.out.println("genericComponentType = " + genericComponentType.getClass().getName());

    }

    private ClientGenericArrayType getType() throws NoSuchFieldException {
        Field listArray = ClientGenericArrayType.class.getDeclaredField("listArray");
        ClientGenericArrayType genericType = (ClientGenericArrayType) listArray.getGenericType();
        return genericType;
    }
}
