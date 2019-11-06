package com.javaapi.test.test.regex;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2019/10/28
 */
public class TestRegex2 {
    @Test
    public void test() {
        String s = "哈哈哈：张三[123];张四[234];  ;";
        String[] split = s.split("哈哈哈：");
        if (split == null || split.length <= 1) {
            return;
        }
        String s1 = split[1];
        System.out.println("s1 = " + s1);
        List<String> strings = Splitter.on(";").omitEmptyStrings().trimResults().splitToList(s1);
        System.out.println("strings = " + strings);
    }

    @Test
    public void test2() {
        String s = " 张三[123] ";
        String message = findMessage(s);
        System.out.println("s = " + message);
    }

    public String findMessage(String message) {
        if (message == null) {
            return null;
        }
        // 注意这里匹配数字的正则必须要用+,至少有一个数字
        String patten = "\\[(.*?)\\]";
        Pattern p = Pattern.compile(patten);
        Matcher matcher = p.matcher(message);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

}
