package com.javaapi.test.util.opensource.apache.commons.lang;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 17/12/22.
 */
public class TestStringUils {


    @Test
    public void test(){
        String fbItem = "*a";
        String fbItem1 = "*a*";
        String fbItemStr = StringUtils.replace(fbItem1, "*", ".*");
        System.out.println("replace = " + fbItemStr);
        Pattern pattern = Pattern.compile(fbItemStr);
        Matcher matcher = pattern.matcher(fbItem);
        System.out.println("matcher.matches() = " + matcher.matches());
    }
    @Test
    public void testRemove(){
        String s = "2018-03-02";
        System.out.println("s = " + s);
        System.out.println("StringUtils = " + StringUtils.remove(s,"-"));
    }

    @Test
    public void testRemoveMany(){
        String s = "2018-03-02 12:12";
        System.out.println("s = " + s);
        System.out.println("StringUtils = " + StringUtils.removePattern(s,"-|\\s|:"));
    }


    @Test
    public void testUpper(){
        String s = "sia";
        String s1 = StringUtils.upperCase(s);
        System.out.println("s1 = " + s1);

    }

}
