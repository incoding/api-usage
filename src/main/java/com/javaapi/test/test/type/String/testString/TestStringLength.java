package com.javaapi.test.test.type.String.testString;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by user on 16/10/26.
 */
public class TestStringLength {
    @Test
    public void test() {
        String a = "aaa";
        System.out.println("a = " + a.length());
        String zhongwen = "你好啊";
        System.out.println("zhongwen = " + zhongwen);
        String a2 = "a你好";
        System.out.println("a = " + a2.length());
    }

    @Test
    public void testName() throws Exception {
        String a = "acd";
        String format = null;
        format = getOverLay(a);
        System.out.println("a = " + format);
    }

    private String getOverLay(String a) {
        if (a.length() == 1) {
            String repeat = StringUtils.repeat("*", 5);
            return String.format("%s%s", a, repeat);
        } else if (a.length() >= 2) {
            String repeat = StringUtils.repeat("*", 4);
            String start = a.substring(0, 1);
            String end = a.substring(a.length() - 1, a.length());
            return String.format("%s%s%s", start, repeat, end);
        }
        return "******";
    }
}
