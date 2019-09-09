package com.javaapi.test.test.testJdk.language.dispatch2;

import org.junit.Test;

/**
 * refer
 * https://blog.csdn.net/hongxingxiaonan/article/details/50447883
 */
public class Client {

    /**
     * 对象 静态分派
     * https://blog.csdn.net/hongxingxiaonan/article/details/50447883
     */
    @Test
    public void testStaticDispatch() {
        Human human = new Human();
        Human man = new Man();
        Man realMan = new Man();

        sayHello(human);
        sayHello(man);
        sayHello(realMan);
    }

    /**
     * 对象 动态分派
     */
    @Test
    public void testDynamicDispatch() {
        Human human = new Human();
        Human man = new Man();
        Man realMan = new Man();

        human.sayHello();
        man.sayHello();
        realMan.sayHello();
    }


    public void sayHello(Human human) {
        System.out.println("human say hello!");
    }

    public void sayHello(Man man) {
        System.out.println("man say hello.");
    }

    private static class Human {
        public void sayHello() {
            System.out.println("say hello in human");
        }

        public void eat(Fruit fruit) {
            System.out.println("human eat fruit.");
        }

        public void eat(Apple apple) {
            System.out.println("human eat apple.");
        }
    }

    private static class Man extends Human {
        public void sayHello() {
            System.out.println("say hello in man");
        }

        public void eat(Fruit fruit) {
            System.out.println("man eat fruit.");
        }

        public void eat(Apple apple) {
            System.out.println("man eat apple.");
        }
    }

    private static class Fruit {
    }

    private static class Apple extends Fruit {
    }

}
