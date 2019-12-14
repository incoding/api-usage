package com.javaapi.test.test.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 2019/10/28
 */
public class TestRegexUpdate {

    private Pattern numberCompile = Pattern.compile("[0-9]+");
    private Pattern nonNumberCompile = Pattern.compile("[^0-9]+");

    /**
     * 提取数字
     */
    @Test
    public void test1() {
        String phoneString = "kk13888889999";
        Matcher matcher = numberCompile.matcher(phoneString);
        String group = null;
        if (matcher.find()) {
            group = matcher.group();
        }

        System.out.println("s = " + group);
    }

    /**
     * 提取非数字
     */
    @Test
    public void test() {
        String phoneString = "";
        Matcher matcher = nonNumberCompile.matcher(phoneString);
        String group = null;
        if (matcher.find()) {
            group = matcher.group();
        }

        System.out.println("s = " + group);
    }

}
