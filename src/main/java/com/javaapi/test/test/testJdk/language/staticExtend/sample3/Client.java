package com.javaapi.test.test.testJdk.language.staticExtend.sample3;

import org.junit.Test;

/**
 * 静态类或者静态方法 调用判断
 * 1 先看外观类型
 * 2 如果是子类会向上搜索父类方法
 */
public class Client {

    /**
     * 判断调用
     */
    @Test
    public void test() {

        Banana banana = new Banana();
        banana.test();     //这是没有被子类覆盖的方法
        banana.call();     //调用Banana类中的call方法    这是一个香蕉
        Fruit fruit = banana;
        fruit.call();      //调用Fruit类中的方法 这是一个水果
        Fruit.call();         //调用Fruit类中的方法 这是一个水果

        System.out.println(banana.xingzhuang + " " + banana.color);   //奇形怪状 黄色
        System.out.println(fruit.xingzhuang + " " + fruit.color);   //奇形怪状 黄色
    }

    /**
     * 方法调用成员变量 决定因素
     * 1 本类有成员变量嘛,有就调用本类
     * 2 搜索父类是否有成员变量
     * <p>
     * <p>
     * 而具体在方法中使用成员变量时，
     * 究竟使用的是父类还是子类的成员变量，
     * 则由方法所在的类决定；
     * 即，方法在父类中定义和执行，则使用父类的成员变量，
     * 方法在子类中定义（包括覆盖父类方法）和执行，则使用子类的成员变量。
     */
    @Test
    public void testUseField() {
        Banana banana = new Banana();
        banana.getColor();  //这是一个香蕉黄色
        banana.getScope();  //这是一个奇形怪状

        //这个getParentColor在父类,所以调用的也是父类的成员变量
        banana.getParentColor(); //这是一个水果五颜六色
        banana.getBananaColor(); //这是一个水果五颜六色
        Fruit fruit = banana;
        fruit.getColor();  // 这是一个水果五颜六色

    }


}
