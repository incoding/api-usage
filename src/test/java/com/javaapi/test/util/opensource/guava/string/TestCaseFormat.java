package com.javaapi.test.util.opensource.guava.string;

import com.google.common.base.CaseFormat;
import org.junit.Test;

public class TestCaseFormat {

    @Test
    public void testCaseFormat() {
        String constant_name = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");// returns "constantName"
        System.out.println("constant_name = " + constant_name);
    }

}
