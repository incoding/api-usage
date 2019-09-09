package com.javaapi.test.test.testJdk.language.staticExtend.sample2;

import org.junit.Test;

/**
 * Created by user on 17/7/5.
 */
public class StaticMethodTest {
    /**
     * 子类没声明field的话,一直用的是父类的field
     */
    @Test
    public void testField() {
        Parent p = new Parent();
        Son son = new Son();
        p.name = "123";
        System.out.println("son = " + son.name);
    }

    /**
     * http://www.cnblogs.com/yaoboyyao/p/3601900.html
     *
     * 输出
     *  father
        son
        father
     */
    @Test
    public void testMethod() {
        Parent p = new Parent();
        Son son = new Son();
        Parent p2 = son;
        p.getName();
        son.getName();

        p2.getName();
    }

}