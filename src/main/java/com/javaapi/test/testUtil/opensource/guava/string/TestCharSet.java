package com.javaapi.test.testUtil.opensource.guava.string;

import com.google.common.base.Charsets;
import org.junit.Test;

public class TestCharSet {

    @Test
    public void testJoiner() {
        byte[] bytes = "nihao".getBytes(Charsets.UTF_8);
        System.out.println("bytes = " + bytes);

    }

}
