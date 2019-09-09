package com.javaapi.test.test.testJdk.language.dispatchStatic;

import org.junit.Test;

/**
 * Created by user on 2019/9/7
 */
public class StaticMethod {
    private static class Human {
        public static void sayHello() {
            System.out.println("human say hello.");
        }
    }

    private static class Man extends Human {
        public static void sayHello() {
            System.out.println("man say hello");
        }
// 重载会报错
//        public void sayHello() {
//        }
    }

    @Test
    public void callMethod() {
        Human.sayHello();
        Man.sayHello();
        System.out.println("-----------");
        Human human = new Human();
        Human man = new Man();
        Man realMan = new Man();
        human.sayHello();
        man.sayHello();
        realMan.sayHello();
    }
}