package com.javaapi.test.test.type.String.testString.toolString.sbcToDbc;

import org.junit.Test;

/**
 *  全角 半角互转
 *  俩个工具类都可以用
 */
public class Client {
    @Test
    public void test(){
        String ｐ = StringUtil.sbc2dbcCase("ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ，。１２３４５６７８９０　＜＞～！＠＃＄％＾＆＊（）＿－＋");
        System.out.println("sbcToDbc转换后 = " + ｐ);


        String p2 = StringUtil.dbc2sbcCase(ｐ);
        System.out.println("dbcToSbc转换后 = " + p2);
    }

    @Test
    public void test2(){
        String ｐ = AsciiUtil.sbc2dbcCase("ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ，。１２３４５６７８９０　＜＞～！＠＃＄％＾＆＊（）＿－＋");
        System.out.println("sbcToDbc转换后 = " + ｐ);


        String p2 = AsciiUtil.dbc2sbcCase(ｐ);
        System.out.println("dbcToSbc转换后 = " + p2);
    }
}
