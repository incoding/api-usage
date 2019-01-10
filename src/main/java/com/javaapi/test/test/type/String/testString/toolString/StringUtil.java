package com.javaapi.test.test.type.String.testString.toolString;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;

public class StringUtil {
    @Test
    public void testEncode() {
        // 上下单双 ,标准形式
        //        String plan = "79=3,80=1,81=0|3*1:1^79=3,80=1,81=0|3*1:1";
        // 上下单双 ,非标准形式
        //        String plan = "79→1,80→1,81→2 1 2 3_1^79→1,80→1,81→2 1 2 3_1";
        // 半全场 ,标准形式
        //        String plan = "79=33,80=31,81=30|3*1:1^79=33,80=31,81=30|3*1:1";
        // 半全场 ,非标准形式
        //        String plan = "79→33,80→11,81→31 1 2 3_1^79→33,80→11,81→31 1 2 3_1";
        // 总进球 ,非标准形式
        //        String plan = "79→0,80→1,81→2 1 2 3_1^79→0,80→1,81→2 1 2 3_1";
        //总进球数，标准形式
        //        String plan = "79=1,80=2,81=3|3*1:1^79=1,80=2,81=3|3*1:1";
        // 比分 ,非标准形式
        //        String plan = "79→10,80→11,81→20 1 2 3_1^79→10,80→11,81→20 1 2 3_1^79→10,80→11,81→20 1 2 3_1";
        // 比分 ，标准形式
        //        String plan = "79=33,80=31,81=30|3*1:1^79=33,80=31,81=30|3*1:1^79=33,80=31,81=30|3*1:1";
        // 胜平负，非标准形式
        //                String plan = "79→3,80→1,81→0 1 2 3_1^79→3,80→1,81→0 1 2 3_1";
        // 胜平负，标准形式
        String plan = "79=3,80=0,81=3|3*1:1^79=3,80=0,81=3|3*1:1^79=3,80=0,81=3|3*1:1^79=3,80=0,81=3|3*1:1";
        try {
            String encode = URLEncoder.encode(plan, "UTF-8");
            System.out.println(encode);
        } catch (UnsupportedEncodingException e) {
        }

    }

    @Test
    public void testEncodeJczq() {
        // 上下单双 ,标准形式
        //        String plan = "79=3,80=1,81=0|3*1:1^79=3,80=1,81=0|3*1:1";
        // 上下单双 ,非标准形式
        //        String plan = "79→1,80→1,81→2 1 2 3_1^79→1,80→1,81→2 1 2 3_1";
        // 半全场 ,标准形式
        //        String plan = "79=33,80=31,81=30|3*1:1^79=33,80=31,81=30|3*1:1";
        // 半全场 ,非标准形式
        //        String plan = "79→33,80→11,81→31 1 2 3_1^79→33,80→11,81→31 1 2 3_1";
        // 总进球 ,非标准形式
        //        String plan = "79→0,80→1,81→2 1 2 3_1^79→0,80→1,81→2 1 2 3_1";
        //总进球数，标准形式
        //        String plan = "79=1,80=2,81=3|3*1:1^79=1,80=2,81=3|3*1:1";
        // 比分 ,非标准形式
        //        String plan = "79→10,80→11,81→20 1 2 3_1^79→10,80→11,81→20 1 2 3_1^79→10,80→11,81→20 1 2 3_1";
        // 比分 ，标准形式
        //        String plan = "79=33,80=31,81=30|3*1:1^79=33,80=31,81=30|3*1:1^79=33,80=31,81=30|3*1:1";
        // 胜平负，非标准形式
        //                String plan = "79→3,80→1,81→0 1 2 3_1^79→3,80→1,81→0 1 2 3_1";
        // 胜平负，标准形式
        String plan = "SPF|140926025[-1]=1,140926026=0,140926027=0|3*1:1^SPF|140926025[-1]=1,140926026=0,140926027=0|3*1:1^SPF|140926025[-1]=1,140926026=0,140926027=0|3*1:1^SPF|140926025[-1]=1,140926026=0,140926027=0|3*1:1";
        try {
            String encode = URLEncoder.encode(plan, "UTF-8");
            System.out.println(encode);
        } catch (UnsupportedEncodingException e) {
        }

    }

    @Test
    public void testDecode() {
        String plan = "ddd^=";
        try {
            String decode = URLDecoder.decode(plan, "UTF-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void testDecodeChineseLang() {
        String plan = "你好";
        try {
            String decode = URLDecoder.decode(plan, "UTF-8");
            System.out.println(decode);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


  

    @Test
    public void testRegx() {
        String content = "sss^sss";
        content = content.replaceAll("\\^", "\r\n");
        System.out.println(content);
    }

    @Test
    public void testReplaceAll() {
        String content = "http://www.baidu.com";
        content = content.replaceAll("www.baidu.com", "www.nihao.com");
        System.out.println(content);
    }

    @Test
    public void testReplaceAll2() {
        String content = "I'm kk";
        content = content.replaceAll("'", "\\\\'");
        System.out.println(content);
    }

    @Test
    public void testReplaceAll3() {
        String content = "[SOSI]倒计时开始！《潜行吧奈亚子》第二季即将上演 ";
        content = content.replaceAll("\\[", "【");
        content = content.replaceAll("\\]", "】");
        System.out.println(content);
    }
    
    @Test
    public void testContains() {
        String string = "FloatL kong";
        String string2 = "FloatL dan";
        String string3 = "FloatL closed";
        String cssClass = "sss FloatL kong";
        String cssClass2 = "sss FloatL dan";
        String cssClass3 = "sss FloatL closed";
        System.out.println(cssClass.contains(string));
        System.out.println(cssClass2.contains(string2));
        System.out.println(cssClass3.contains(string3));

    }

    @Test
    public void testSplit() {
        String string = "200.0-8.00-18.00-12.00-55.00-38.00-42.00-150.0-120.0-150.0-500.0-400.0-600.0-500.0-6.50-6.20-17.00-80.00-80.00-5.30-6.75-7.50-14.00-15.00-27.00-34.00-36.00-70.00-100.0-100.0-200.0";
        String[] split = string.split("-");
        for (String string2 : split) {
            System.out.println(string2);
        }
    }

    @Test
    public void testSplit4() {
        String string = "Y/M/K/C";
        String[] split = string.split("/");
        for (String string2 : split) {
            System.out.println(string2);
        }
    }
    @Test
    public void test() {
    	String string = ",123,123";
    	string = string.substring(1, string.length());
    	System.out.println(string);
    }

//    @Test
//    public void testStringJoiner() throws Exception {
//        StringJoiner sj = new StringJoiner(",");
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
////        list.forEach((str) -> sj.add(str));
////        System.out.println("sj = " + sj.toString());
//    }
//    @Test
//    public void testStringJoiner2() throws Exception {
//        StringJoiner sj = new StringJoiner(",");
//        sj.add("a");
//        sj.add("b");
//        System.out.println("sj = " + sj);
//    }
//
//    /**
//     * param 1 分隔符
//     * param 2 开始符号
//     * param 3 结束符号
//     * @throws Exception
//     */
//    @Test
//    public void testUrlParam() throws Exception {
//        StringJoiner sj = new StringJoiner("&","?","");
//        sj.add("a=123");
//        sj.add("b=32");
//        sj.add("c=13");
//        System.out.println("sj = " + sj);
//        // merge 忽略起始和结束
//        StringJoiner sj2 = new StringJoiner("^","*","*");
//        sj2.add("key = value");
//        sj2.add("key2 = value2");
//        sj.merge(sj2);
//        System.out.println("sj merge = " + sj);
//
//    }

    @Test
    public void testStringSpliter() throws Exception {
        //前面的逗号有效
        System.out.println("strings = " + Arrays.asList("a".split(",")));
        System.out.println("strings = " + Arrays.asList(",a".split(",")));
        // 最后的逗号不会分割
        System.out.println("strings = " + Arrays.asList("a,".split(",")));
        System.out.println("strings = " + Arrays.asList("a,b,".split(",")));
    }

    @Test
    public void testCharset() {
        Charset charset = Charset.defaultCharset();
        System.out.println("charset = " + charset);
    }

    @Test
    public void testSplit2(){
        String s = "|2|3|";
        String[] split = s.split("\\|");
        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }
        System.out.println("----------");

        String a = " ";
        String[] split1 = a.split("\\|");
        System.out.println(split1.length);
        System.out.println(Arrays.asList(split1));
    }
    @Test
    public void testSplit3(){
        String s = "3##2##3##";
        String[] split = s.split("##");
        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }
        System.out.println("----------");
    }
    @Test
    public void testOutput(){
        String s = "1\n2";
        System.out.println(s);
    }
}
