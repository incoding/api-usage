package com.javaapi.test.test.reflect.genericType;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 http://www.jianshu.com/p/e8eeff12c306
 */
public class ClientParameterizedType {
    private Map.Entry<String, Integer> mapEntry;

    private Map<String,Integer> map;


    /**
     *1 getGenericType先获取泛型类型 ParameterizedType
      2 在根据ParameterizedType 调用getActualTypeArguments/getRawType/getOwnerType
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void getGenericType() throws NoSuchFieldException {
        Field mapEntry = ClientParameterizedType.class.getDeclaredField("map");
        Type genericType = mapEntry.getGenericType();
        System.out.println("genericType = " + genericType.getClass().getTypeName());

    }




    /**
     * 获取泛型中的实际类型，可能会存在多个泛型，例如Map<K,V>,所以会返回Type[]数组；

     *
     * @throws NoSuchFieldException
     */
    @Test
    public void getActualTypeArguments() throws NoSuchFieldException {
        ParameterizedType type = getType("map");
        Type[] actualTypeArguments = type.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println("actualTypeArgument = " + actualTypeArgument);
        }
    }


    /**
     * 获取声明泛型的类或者接口，也就是泛型中<>前面的那个值；
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void getRawType() throws NoSuchFieldException {
        ParameterizedType type = getType("map");
        System.out.println("getRawType = " + type.getRawType());
    }

    /**
     * getOwnerType 显示内部类实际代码是定义在哪个类里
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void getOwnerType() throws NoSuchFieldException {
        ParameterizedType ownerType = getType("mapEntry");
        System.out.println("ownerType = " + ownerType.getOwnerType());
    }

    private ParameterizedType getType(String map) throws NoSuchFieldException {
        Field field = ClientParameterizedType.class.getDeclaredField(map);
        Type genericType = field.getGenericType();
        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        return parameterizedType;
    }
}
