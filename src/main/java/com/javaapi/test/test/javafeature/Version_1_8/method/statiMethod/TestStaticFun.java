package com.javaapi.test.test.javafeature.Version_1_8.method.statiMethod;


/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-jdk8newfeature/
 */
public class TestStaticFun {
    public static void main(String[] args) {
//接口中定义了静态方法 find 直接被调用

        System.out.println("args = " + StaticFunInterface.findOne());
        System.out.println("args = " + StaticFunInterface.findAll());
    }
}