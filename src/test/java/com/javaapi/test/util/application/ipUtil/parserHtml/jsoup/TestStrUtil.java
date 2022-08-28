package com.javaapi.test.util.application.ipUtil.parserHtml.jsoup;

import org.junit.Test;

public class TestStrUtil {
    public TestStrUtil() {
    }

    @Test
    public void testRemove() {
        String nihao = "<p>哈哈哈哈</p><a>aa</a>";
        String s = StrUtil.removeIlleaglString(nihao);
        System.out.println("s = " + s);
    }

    @Test
    public void testRemove2() {
        String nihao = "<p>哈哈哈哈<a>aa</a>";
        String s = StrUtil.removeIlleaglString(nihao);
        System.out.println("s = " + s);
    }

    @Test
    public void testRemoveTag() {
        String nihao = "<style> aaaaaaa </style><div>bbbbbbb</div>";
        String s = StrUtil.removeIlleaglString(nihao);
        System.out.println("s = " + s);
    }

    @Test
    public void testRemoveAttr() {
        String nihao = "<style> aaaaaaa </style><div width='12' >bbbbbb</div>";
        String s = StrUtil.removeIlleaglString(nihao);
        System.out.println("s = " + s);
    }

    @Test
    public void testRemoveCssInStyle() {
        String nihao = "<div style=\"width:12;background:url('http://www.baidu.com')\" >nihoassss</div><div>22222</div>";
        String s = StrUtil.removeIlleaglString(nihao);
        System.out.println("s = " + s);
    }
}