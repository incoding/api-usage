package com.javaapi.test.test.javafeature.innerClass;

import com.javaapi.test.test.javafeature.innerClass.featureReadEachother.ClientOuterReadInner;
import org.junit.Test;

/**
 * http://www.cnblogs.com/dolphin0520/p/3811445.html （好）
 * 
 * 
 */
public class ClientReadEachother {


    /**
     * 内部类可以拥有private访问权限、protected访问权限、public访问权限及包访问权限。比如上面的例子，如果成员内部类Inner用private修饰，则只能在外部类的内部访问，如果用public修饰，则任何地方都能访问；如果用protected修饰，则只能在同一个包下或者继承外部类的情况下访问；如果是默认访问权限，则只能在同一个包下访问。
     * 这一点和外部类有一点不一样，外部类只能被public和包访问两种权限修饰。
     * 我个人是这么理解的，由于成员内部类看起来像是外部类的一个成员，所以可以像类的成员一样拥有多种权限修饰。
     */
    @Test
    public void testInit() {
        //编译错误
//        ClientOuterReadInner.ClientInnerPrivate innerPrivate = new ClientOuterReadInner.ClientInnerPrivate();
//        System.out.println(innerPrivate.getName());
//
//        ClientOuterReadInner.ClientInnerPrivate innerPrivate2 = new ClientOuterReadInner().new ClientInnerPrivate();
//        System.out.println(innerPrivate2.getName());
//
//
//        ClientInnerPrivate innerPrivate3 = new ClientOuterReadInner().new ClientInnerPrivate();
//        System.out.println(innerPrivate3.getName());
//        ClientInnerPrivate innerPrivate4 = new ClientOuterReadInner.ClientInnerPrivate();
//        System.out.println(innerPrivate4.getName());
//
//
//        ClientInnerPrivate inner = new ClientInnerPrivate();
//        System.out.println(inner.getName());
    }

    /**
     * http://www.sjsjw.com/kf_mobile/article/030656ABA002590.asp
     */
    @Test
    public void testOuterOuterReadInnerPrivate(){
//        ClientInnerPrivate inner = new ClientInnerPrivate(); // 找不到

    }

    @Test
    public void testOuterOuterReadProtect(){
//        ClientOuterReadInner.ClientInnerProtected clientInner = new ClientOuterReadInner.ClientInnerProtected();  //error
//        ClientOuterReadInner outer = new ClientOuterReadInner();
        // 找不到
//        ClientOuterReadInner.ClientInnerProtected outerProtect = outer.new ClientInnerProtected();
//        outer.testInitInOuter();
    }

    @Test
    public void testOuterOuterReadPublic(){
//        ClientOuterReadInner.ClientInnerProtected clientInner = new ClientOuterReadInner.ClientInnerProtected();  //error
        ClientOuterReadInner outer = new ClientOuterReadInner();
        ClientOuterReadInner.ClientInnerPublic outerProtect = outer.new ClientInnerPublic();
        outer.testInitInOuter();
    }

    /**
     * 不需要外部类实例，但是还是需要外部类.内部类
     */
    @Test
    public void testClientStaticInnerPublic(){
        ClientOuterReadInner.ClientStaticInnerPublic c = new ClientOuterReadInner.ClientStaticInnerPublic();
        System.out.println("c = " + c);
    }
}
