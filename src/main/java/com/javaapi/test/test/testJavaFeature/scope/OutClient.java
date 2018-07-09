package com.javaapi.test.test.testJavaFeature.scope;

import com.javaapi.test.test.testJavaFeature.scope.model.InnerEntityPublick;
import org.junit.Test;

/**
 * Created by user on 15/9/4.
 */
public class OutClient {
    @Test
    public void  test(){
    }
    @Test
    public void test2() {
        InnerEntityPublick in = new InnerEntityPublick();
//        System.out.println("in = " + in.name);
    }

    @Test
    public void testName() throws Exception {
        OutIn o = new OutIn();
        System.out.println("o = " + o.getProtected());

    }
}
