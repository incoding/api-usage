package com.javaapi.test.test.javafeature.innerClass.featureInit;

import com.javaapi.test.test.javafeature.innerClass.featureReadEachother.ClientOuterReadInner;
import org.junit.Test;

/**
 * java内部类的初始化
 * 参考 http://blog.csdn.net/songdexv/article/details/6758972
 * http://www.cnblogs.com/dolphin0520/p/3811445.html
 *
 *
 *
 **/
public class InnerClassTest {


    /**
     * 在其他类里初始化外部类里的内部类 ,只能使用   外部类的实例来初始化
     * 在外部类中初始化可以有2种方式 参见 @ClientOuterReadInner
     */
    @Test
    public void testInitInOuter() {

        ClientOuterReadInner.ClientInnerPublic innerPublic2 = new ClientOuterReadInner().new ClientInnerPublic();
        System.out.println(innerPublic2.getName());

    }


    /**
     * 普通内部类 初始化需要依赖外部类实例
     */
    @Test
    public void testInner() {
        InnerClassTest.Inner inner = new InnerClassTest().new Inner();
        inner.show();
    }

    /**
     * 静态内部类初始化,不需要外部类实例
     * @throws Exception
     */
    @Test
    public void testStaticInner() throws Exception {
        InnerClassTest.StaticInner staticInner = new InnerClassTest.StaticInner();
        staticInner.show();
    }

    private static class StaticInner {
        public void show() {
            System.out.println("static inner class show");
        }
    }

    private class Inner {
        public void show() {
            System.out.println("inner class show");
        }
    }
}
