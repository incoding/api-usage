package com.javaapi.test.test.testJavaFeature.Version_1_8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TestClient {
    /*http://www.cnblogs.com/figure9/archive/2014/10/24/4048421.html*/

    /**
     * stream里的return 相当于foreach 里的continue
     */
    @Test
    public void test() {

        List<String> list = new ArrayList<>();
        list.add("nihao");
        list.add("nihao2");
        list.add("nihao3");
        list.add("nihao4");
        list.stream().forEach((s -> {
            if (s.equals("nihao2")) {
                return;
            }
            System.out.println("s = " + s);
        }));


    }
}
