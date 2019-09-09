package com.javaapi.test.test.testJdk.language.staticExtend.sample1;

import org.junit.Test;

/**
 * Created by user on 17/7/5.
 */
public class StaticMethodTest {
    /**
     * 父子类共用    静态属性
     */
    @Test
    public void testField() {
        Parent p = new Parent();
        Son sonInstance = new Son();
        p.name = "1";
        System.out.println("son = " + sonInstance.name);
        System.out.println("Son = " + Son.name);
    }

    /**
     * 父子类共用    静态方法
     */
    @Test
    public void testMethod() {
        Parent p = new Parent();
        Son son = new Son();
        p.name = "1";
        System.out.println("son = " + son.name);
        Son.getName();
    }
/**
 * 静态方法属于静态绑定,在编译阶段已经确定函数名和地址,静态方法当然是可以被继承的,但是却不能被重写,为什么那?
 因为重写的意思是重新定义父类的虚函数,但是虚函数是动态绑定的,而静态方法是静态绑定的,所以静态函数必然不能是虚函数,也就不存在所说的重写了.你在子类中重新写一个同名的函数,覆盖了父类的同名函数,在使用子类指针进行调用的时候,调用的就是子类的这个静态方法
 */
}