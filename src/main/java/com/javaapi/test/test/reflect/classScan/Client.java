package com.javaapi.test.test.reflect.classScan;

import org.junit.Test;

import java.util.List;

/**
 * Created by wk on 17-4-14.
 * 获取jar中的类,
 * 注意 内部类  获取的是这样的 org.apache.commons.lang3.time.DurationFormatUtils$Token
 * 注意 匿名内部类获取是这样的 com.javaapi.test.test.testReflect.classScan.ClassUtil$1
 */
public class Client {
    /**
     * 获取源码中的类
     */
    @Test
    public void testScanClassInSource() {
        List<Class<?>> classes = ClassUtil.getClasses("com.javaapi.test.test.testReflect.classScan");
        System.out.println("classes = " + classes);
    }

    /**
     * 获取jar中的类,
     * 注意 内部类  获取的是这样的 org.apache.commons.lang3.time.DurationFormatUtils$Token
     * 注意 匿名内部类获取是这样的 com.javaapi.test.test.testReflect.classScan.ClassUtil$1
     */
    @Test
    public void testScanClassInJar(){
        String packageName = "org.apache.commons.lang3.time";
        List<Class<?>> classes = ClassUtil.getClasses(packageName);
        System.out.println("classes = " + classes);

    }
}
