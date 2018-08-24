package com.javaapi.test.spring.feature.util;

import org.codehaus.plexus.util.SelectorUtils;
import org.junit.Test;

/**
 * Created by user on 16/4/7.
 */
public class TestAntPattern {
    /**
     *     ?只能匹配单个字符 (不能匹配  路径分隔符)
     */
    @Test
    public void test() {
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/?.xml", "src/main/java/com/test/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/?.xml", "src/main/java/com/test/a.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/?.xml", "src/main/java/com/test//.xml"));
    }

    /**
     *       一个* 只能匹配任意文件名字(不能匹配任意目录)
     */
    @Test
    public void test2() {
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/*.xml", "src/main/java/com/test/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/**/*.xml", "src/main/java/com/test/aa.xml"));
    }
    /**
     *        俩个**
     *         在中间只能匹配任意目录
     *         在开头/最后可以配置文件和目录
     **/
    @Test
    public void testName() throws Exception {
        System.out.println("match = " + SelectorUtils.matchPath("**/src", "aa/src"));
        System.out.println("match = " + SelectorUtils.matchPath("**/src", "aa.xml/src"));
        System.out.println("match = " + SelectorUtils.matchPath("src/**.xml", "src/aaa/java/com/test/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/**", "src/aaa/java/com/test/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/**", "src/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/**", "src"));
        System.out.println("match = " + SelectorUtils.matchPath("src/**/java/**/*.**", "src/aaa/java/com/test/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/**/java/**/*.**", "src/aaa/java/com/test/aa.properties"));
    }
    /**
     *              路径前面有斜杠,则pattern也要有斜杠
     *              pattern有斜杠,路径前面也要有斜杠
     *              路径后面,或者pattern后面有无斜杠都能匹配
     * */
    @Test
    public void test3() throws Exception {
        System.out.println("match = " + SelectorUtils.matchPath("src/*", "/src/a.xml"));

        System.out.println("match = " + SelectorUtils.matchPath("src/*", "src"));

        System.out.println("match = " + SelectorUtils.matchPath("/src", "src"));
        System.out.println("match = " + SelectorUtils.matchPath("/src", "/src"));

        System.out.println("match = " + SelectorUtils.matchPath("src", "src/"));
        System.out.println("match = " + SelectorUtils.matchPath("src", "src"));

        System.out.println("match = " + SelectorUtils.matchPath("src/", "src"));
        System.out.println("match = " + SelectorUtils.matchPath("src/", "src/"));
    }

    @Test
    public void testAll() {
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/*.xml", "src/main/java/com/test/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/**/*.xml", "src/main/java/com/test/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/*.xml", "src/main/java/aa.xml"));
        System.out.println("match = " + SelectorUtils.matchPath("src/main/java/**/*.xml", "src/main/java/aa.xml"));
    }

}
