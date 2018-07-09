package com.javaapi.test.test.testJavaFeature.innerClass.featureVarScope;

import org.junit.Test;

/**
 * 内部类的变量 scope
 * http://www.cnblogs.com/dolphin0520/p/3811445.html
 */
public class Client {
    @Test
    public void test(){
        Outter outter = new Outter();
        outter.new Inner().print();
    }
}
