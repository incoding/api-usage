package com.javaapi.test.testUtil.opensource.guava.string;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;
import org.testng.collections.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJoiner {
    /**
     * 没有jdk 8 ,可以用这个方案替代
     * 根据map生成url
     */
    @Test
    public void testJoiner() {
        Map<String,String> params = new HashMap<>();
        params.put("nihao", "nihao");
        params.put("nihao2", "nihao2");
        String result = Joiner.on("&").withKeyValueSeparator("=").join(params);
        System.out.println(result);
    }
    @Test
    public void testJoiner21() {
        Map<String,String> params = new HashMap<>();
        params.put("nihao", "nihao");
        params.put("nihao2", "nihao2");
        String result = Joiner.on("<br>").withKeyValueSeparator(":").join(params);
        System.out.println(result);
    }

    /**
     * map生成url 方式2
     */
    @Test
    public void testJoiner2() {
        Map<String,Object> params = new HashMap<>();
        params.put("nihao", 1);
        params.put("nihao2", "nihao2");
        StringBuilder url = new StringBuilder("http://www.baidu.com?");
        StringBuilder stringBuilder = Joiner.on("&").appendTo(url, params.entrySet().iterator());
        System.out.println(stringBuilder);
    }


    @Test
    public void testJoiner3() {
        String join = Joiner.on("_").join("nihao", "nihao2");
        System.out.println("join = " + join);
    }
    @Test
    public void testJoiner4() {
        String join = Joiner.on("_").skipNulls().join("nihao", "");
        System.out.println("join = " + join);
    }

    @Test
    public void testJoiner5() {
        List<String> strings = Lists.newArrayList("a", "b");
        String s = Joiner.on("_").skipNulls().appendTo(new StringBuilder(), strings).toString();
        System.out.println("s = " + s);

    }


}
