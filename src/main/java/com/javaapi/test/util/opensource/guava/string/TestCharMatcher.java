package com.javaapi.test.util.opensource.guava.string;

import com.google.common.base.CharMatcher;
import org.junit.Test;

/**
 * Created by user on 17/7/10.
 */
public class TestCharMatcher {
    @Test
    public void testCaseFormat() {
        String string = " s   ss888s99 ";
        String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom(string); //移除control字符
        System.out.println("noControl = " + noControl);
        String theDigits = CharMatcher.DIGIT.retainFrom(string); //只保留数字字符
        System.out.println("theDigits = " + theDigits);
        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' ');
        System.out.println("spaced = " + spaced);
//去除两端的空格，并把中间的连续空格替换成单个空格
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"); //用*号替换所有数字
        System.out.println("noDigits = " + noDigits);
        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string);
// 只保留数字和小写字母
        System.out.println("lowerAndDigit = " + lowerAndDigit);
    }
}
