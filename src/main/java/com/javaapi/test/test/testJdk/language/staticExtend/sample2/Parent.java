package com.javaapi.test.test.testJdk.language.staticExtend.sample2;

/**
 * Created by user on 17/7/5.
 */
class Parent{
    public static String name ;
    public String desc;
    public static void getName(){
        name = "father";
        System.out.println(name);
    }
    public void getDesc(){
        desc = "father's Desc";
        System.out.println(desc);
    }
}
