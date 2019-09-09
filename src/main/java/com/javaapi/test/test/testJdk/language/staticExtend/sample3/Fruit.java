package com.javaapi.test.test.testJdk.language.staticExtend.sample3;

/**
 * Created by user on 2019/9/8
 */
public class Fruit {

    static String color = "五颜六色";
    static String xingzhuang = "奇形怪状";

    static public void call() {
        System.out.println("这是一个水果");
    }

    static public void test() {
        System.out.println("这是没有被子类覆盖的方法");
    }

    static public void getColor() {
        System.out.println("这是一个水果" + color);
    }

    static public void getParentColor() {
        System.out.println("这是一个水果" + color);
    }
}