package com.javaapi.test.test.testReflect.classScan;

import jodd.util.ClassLoaderUtil;
import org.junit.Test;

import java.util.List;

/**
 * Created by wk on 17-4-14.
 */
public class Client {
    @Test
    public void test(){
        List<Class<?>> classes = ClassUtil.getClasses("com.javaapi.test.test.testReflect.classScan");
        System.out.println("classes = " + classes);
    }
}
