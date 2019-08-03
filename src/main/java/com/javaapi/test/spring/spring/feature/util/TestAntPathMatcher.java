package com.javaapi.test.spring.spring.feature.util;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PatternMatchUtils;

public class TestAntPathMatcher {
    @Test
    public void testAntMatcher() {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        String pattern = "/*/*pigeon=1";
        String pattern2 = "/*?*pigeon=1";
        String pattern3 = "/*?**pigeon=1";
        String pattern4 = "/**pigeon=1";
        String pattern5 = "/**/*.do*pigeon=1";
        String path = "/pigeon/manager.do?version=1.0&pigeon=1";
        boolean match = antPathMatcher.match(pattern, path);
        boolean match2 = antPathMatcher.match(pattern2, path);
        boolean match3 = antPathMatcher.match(pattern3, path);
        boolean match4 = antPathMatcher.match(pattern4, path);
        boolean match5 = antPathMatcher.match(pattern5, path);
        System.out.println(match);
        System.out.println(match2);
        System.out.println(match3);
        System.out.println(match4);
        System.out.println(match5);
    }

    @Test
    public void testPatternMatchUtils() throws Exception {
        String mappedName = "get*";
        String methodName = "getBill";
        boolean simpleMatch = PatternMatchUtils.simpleMatch(mappedName,
                methodName);
        System.out.println(simpleMatch);
    }

    @Test
    public void test() throws Exception {
        String price = "750.00HBFX160";
        String s = "*HBFX*";
        boolean b = PatternMatchUtils.simpleMatch(s, price);
        System.out.println("b = " + b);

    }
}
