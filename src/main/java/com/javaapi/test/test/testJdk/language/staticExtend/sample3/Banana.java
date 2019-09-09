package com.javaapi.test.test.testJdk.language.staticExtend.sample3;

/**
 * Created by user on 2019/9/8
 */
public class Banana extends Fruit {

    static String color = "黄色";

    static public void call() {
        System.out.println("这是一个香蕉");
    }

    static public void getColor() {
        System.out.println("这是一个香蕉" + color);
    }

    static public void getScope() {
        System.out.println("这是一个" + xingzhuang);
    }

    static public void getBananaColor() {
        getParentColor();
    }

}
