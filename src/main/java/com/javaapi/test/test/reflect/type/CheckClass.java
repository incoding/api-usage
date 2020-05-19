package com.javaapi.test.test.reflect.type;

import com.javaapi.test.test.reflect.People;
import org.junit.Test;

import java.util.ArrayList;

/**
 * refer https://blog.csdn.net/it_java_shuai/article/details/78319291
 */
public class CheckClass {


    /**
     * class 对象相同
     * answer is true
     * <p>
     * refer
     * https://blog.csdn.net/zhangzeyuaaa/article/details/17289553
     */
    @Test
    public void testGetClass() {
        if (String.class == "a".getClass()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        Class<?> aClass = null;
        try {
            aClass = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (String.class == aClass) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    /**
     * 看看到底获得是什么样的类型
     */
    @Test
    public void testGetClassType() {
        Class<?> aClass1 = new Object().getClass();
        Class<? extends People> aClass2 = new People().getClass();
        Class<? extends String> aClass = "a".getClass();
        Class<String> stringClass = String.class;
    }

    @Test
    public void testGetClass3() {
        Class<? extends String> aClass = "a".getClass();
        testClass(aClass);

    }

    public void testClass(Class<?> classObject) {
        if (String.class == classObject) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


    /**
     * instance of 函数形式是 isInstance
     */
    @Test
    public void testIsInstance() {
        String s = new String("javaisland");
        System.out.println(s instanceof String); //true
        String s2 = new String("javaisland");
        System.out.println(String.class.isInstance(s2)); //true
    }

    /**
     * 类型转换的函数形式
     */
    @Test
    public void testCast() {
        Object str = "javaisland";
        if (String.class.isInstance(str)) {
            String a = String.class.cast(str);
            System.out.println("a = " + a);
        }

    }

    @Test
    public void testIsAssignableFrom() {
        System.out.println(ArrayList.class.isAssignableFrom(Object.class));  //false
        System.out.println(Object.class.isAssignableFrom(ArrayList.class));  //true
    }


}
