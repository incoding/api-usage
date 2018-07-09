package com.javaapi.test.test.testJavaFeature.innerClass.featureStaticInner;

import com.javaapi.test.test.testJavaFeature.innerClass.featureReadEachother.ClientOuterReadInner;
import org.junit.Test;


public class ClientUseStaticInner {

    /**
     * 不需要外部类实例，
     * 但是必须
     * 外部类.内部类
     */
    @Test
    public void testClientStaticInnerPublic(){
        ClientOuterReadInner.ClientStaticInnerPublic c = new ClientOuterReadInner.ClientStaticInnerPublic();
        System.out.println("c = " + c);
    }
}
