package com.javaapi.test.test.testJdk.language.fieldoveride;

/**
 * JAVA: 子类“覆盖”父类的成员变量
 */
public class Dad extends Person {
    String name = "Dad";
    String age = "33";

    public void getDadAge() {
        getAge();
    }


    public void getSelfAge() {
        System.out.println("age=" + age);
    }
}
