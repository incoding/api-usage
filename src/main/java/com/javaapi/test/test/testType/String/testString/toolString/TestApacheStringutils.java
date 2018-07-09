package com.javaapi.test.test.testType.String.testString.toolString;

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
	
}
