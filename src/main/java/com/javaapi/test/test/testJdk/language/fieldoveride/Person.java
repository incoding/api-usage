package com.javaapi.test.test.testJdk.language.fieldoveride;

/**
 * Created by user on 2019/9/8
 */
public class Person {
    String age = "30";
    String name = "Person";

    public void printName() {
        System.out.println(name);
    }

    public void getAge() {
        System.out.println(age);
    }

}