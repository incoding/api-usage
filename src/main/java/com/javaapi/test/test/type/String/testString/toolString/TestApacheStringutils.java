package com.javaapi.test.test.type.String.testString.toolString;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TestApacheStringutils {

    @Test
    public void testArrayString() {
        List<String> list = new ArrayList<>();
        list.add("你好");
        list.add("世界");
        String join = StringUtils.join(list.toArray(), "，");
        System.out.println(join);
    }
    
    
	@Test
	public void test() {
		String str = "helloworld";
		String center = StringUtils.center(str, 10+str.length(), "#");
		System.out.println(center);
	}

    @Test
    public void testSubString() throws Exception {
        String s = "12345678912";
        String getre = getHeadAndTail(s);
        System.out.println("getHeadAndTail = " + getre);
    }

    private String getHeadAndTail(String s) {
        int length = s.length();
        String substring = s.substring(0, 4);
        String substring1 = s.substring(length - 4, length);
        return substring+substring1;
    }
}
