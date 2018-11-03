package com.javaapi.test.util.application.ipUtil.Locale;


import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocaleTest {
    private static Map<String, String> map = new HashMap<>();
    static {
        Locale[] list = Locale.getAvailableLocales();
        for (Locale locale : list) {
            map.put(locale.getDisplayCountry(), locale.getCountry());
        }
    }

    @Test
    public void test() {
        System.out.println("map = " + map.get("日本"));
        System.out.println("map = " + map.get("台湾"));
        System.out.println("map = " + map.get("中国"));

    }

    /**
     * 获取java所支持的国家和语言
     *
     * @param args
     */
    public static void main(String[] args) {
        Locale[] list = Locale.getAvailableLocales();
        for (Locale locale : list) {
            System.out.print(" 国家:" + locale.getDisplayCountry());
            System.out.print(" 语言:" + locale.getDisplayLanguage());
            System.out.print(" 显示名字:" + locale.getDisplayName());
            System.out.print(" 显示脚本:" + locale.getDisplayScript());
            System.out.print(" 显示变量:" + locale.getDisplayVariant());
            System.out.println();
        }
    }
}

