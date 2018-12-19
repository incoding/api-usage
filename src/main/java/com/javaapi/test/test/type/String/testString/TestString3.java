package com.javaapi.test.test.type.String.testString;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class TestString3 {
    /** intern方法
     *         // 将堆中字符串放进常量池中,然后返回堆中字符串
     * @throws Exception
     */
    @Test
    public void testIntern() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        //在堆中生成一个 ab 字符串
        String a = sb.toString();
        // 将堆中字符串放进常量池中,然后返回堆中字符串
        String b = a.intern();
        // 此时ab都为堆中字符串 所以相等
        System.out.println(a == b);

        // intern第二次调用后就直接从常量池里返回ab字符串,所以与 常量 ab 字符串指向同一引用
        System.out.println("ab" == a.intern());
    }

    /**
     * "a"+"b"  这种+号俩边是字面量相加会提前优化好 将a,b,ab放入常量池
     *
     * @throws Exception
     */
    @Test
    public void testStringpool() throws Exception {
        String a = "a" + "b";
        String b = a.intern();
        System.out.println(a == b);

        System.out.println("ab" == a.intern());
    }
    /**
     * + 号俩边有变量就在堆中生成
     *
     * @throws Exception
     */
    @Test
    public void testStringpool2() throws Exception {
        String a0 = "b";
        String a = "a" + a0;
        System.out.println("ab" == a);
    }

    @Test
    public void testStringpool3() throws Exception {
        StringBuilder a = new StringBuilder();
        a.append("a");
        a.append("b");
        String s = a.toString();
        // ab已经有值了,说明
        System.out.println("ab" == s.intern());
    }

    /**
     * concat都在堆中操作
     * @throws Exception
     */
    @Test
    public void testStringpoolConcat() throws Exception {
        String a = "a".concat("b");
        System.out.println("ab" == a);
    }
    /**
     * concat都在堆中操作
     * @throws Exception
     */
    @Test
    public void testStringpoolConca2() throws Exception {
        String a0 = "b";
        String a = "a".concat(a0);
        System.out.println("ab" == a);
    }


    /**
     * 测试全部,但是太过复杂
     */
    @Test
    @Deprecated
    public  void testAll() {
        // 在池中和堆中分别创建String对象"abc",s1指向堆中对象
        String s1 = new String("abc");
        // s2直接指向池中对象"abc"
        String s2 = "abc";
        // 在堆中新创建"abc"对象，s3指向该对象
        String s3 = new String("abc");
        // 在池中创建对象"ab" 和 "c"，并且s4指向池中对象"abc"
        String s4 = "ab" + "c";
        // c指向池中对象"c"
        String c = "c";
        // 在堆中创建新的对象"abc"，并且s5指向该对象
        String s5 = "ab" + c;

        String s6 = "ab".concat("c"); // 使用concat 不会加入常量池
        String s7 = "ab".concat(c);
        String s8 = new String(new char[] { 'a', 'b', 'c' });
        String s9 = new String(new char[] { 'a', 'b', 'c' });
        String s10 = new String(new char[] { 'a', 'b', 'c' });
        String s11 = new String(new char[] { 'a' })
                + new String(new char[] { 'b' })
                + new String(new char[] { 'c' });
        String s12 = new String(new char[] { 'c' }).intern(); // 与s2内存地址不同,说明变量+号俩边,有变量(而且不是静态变量)就不会在字符串池中找
        String s13 = "ab" + s12;
        System.out.println("------------实串-----------");
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s3); // false
        // s2 是池中的"abc"
        System.out.println(s2 == s3); // false
        System.out.println(s2 == s4); // true
        System.out.println(s2 == s5); // false
        System.out.println(s2 == s6); // false
        System.out.println(s2 == s7); // false
        System.out.println(s2 == s8.intern()); // true
        System.out.println(s2 == s8); // false
        System.out.println(s2 == s9); // false
        System.out.println(s2 == s10); // false
        System.out.println(s2 == s11); // false
        System.out.println(s6 == s7); // false
        System.out.println(s6 == s7); // false
        System.out.println(s2 == s13); // false
        System.out.println(s12 == c); // true
        String b1 = new String("");
        String b2 = "";
        String b3 = new String("");
        String b4 = "".intern();
        String b5 = "" + "";
        String b6 = "".concat("");
        String b7 = "  ".trim();
        String b8 = "  ";
        String b9 = "    ".trim();

        System.out.println("------------空串-----------");
        System.out.println(b1 == b2); // false
        System.out.println(b1 == b3); // false
        System.out.println(b2 == b3); // false
        System.out.println(b2 == b4); // true
        System.out.println(b2 == b5); // true*
        System.out.println(b2 == b6); // true*
        System.out.println(b2 == b7); // false*
        System.out.println("-----a----");
        System.out.println(b2.equals(b7)); // true
        System.out.println(b7 == b8); // false
        System.out.println(b7 == b9); // false
        System.out.println(b7.equals(b9)); // true
        System.out.println(b9 == null);// false

        System.out.println("b8.trim():");
        for (byte b : b8.getBytes()) {
            System.out.print(">>>" + (int) b + " ");
        }
        System.out.println("\nb8.trim():");
        for (byte b : b8.trim().getBytes()) {
            System.out.print(">>>" + (int) b + " ");
        }
        System.out.println("\nb9.trim():");
        for (byte b : b9.trim().getBytes()) {
            System.out.print(">>>" + (int) b + " ");
        }
    }

    @Test
    public void testName() throws Exception {
        String tagName = "nihaoo###";
        Map<String, Object> map = new HashMap<>();
        List<String> sensitiveSymbol = Arrays.asList(new String[]{"#", ",", "/"});
        for (String symbol : sensitiveSymbol) {
            if (this.contains(tagName, symbol)) {
                map.put("result", "标签不能插入“＃”、“，”、“／”符号");
                map.put("success", false);
                System.out.println("symbol = " + map);
                return;
            }
        }

    }

    @Test
    public void testName2() throws Exception {

        String tagName = "nihaoo###";
        List<String> sensitiveSymbol = Arrays.asList(new String[]{"#", ",", "/"});
        for (String symbol : sensitiveSymbol) {
            if (tagName.contains(symbol)) {
                System.out.println("symbol = " + symbol);
            }
        }

    }

    @Test
    public void testSplit() throws Exception {
        String users = ",2,3,";
        List<String> strings = Arrays.asList(users.split(","));
        System.out.println("strings = " + strings);

        String rules = "5-2-10";
        List<String> split = Arrays.asList(rules.split("-"));

        System.out.println("split = " + split);
    }


    @Test
    public void testSplit2() throws Exception {
        String users = "23";
        String[] split = users.split(",");
        System.out.println("split = " + split);
    }

    public static boolean contains(String str, String search) {
        if (StringUtils.isBlank(str) || StringUtils.isBlank(search)) {
            return false;
        }
        String reg = StringUtils.replace(search, "*", ".*");
        Pattern p = Pattern.compile(reg);
        return p.matcher(str).matches();
    }
    @Test
    public void testSubString() {
        String a = "CNjU3OTU27MA==";
        int length = a.length();
        String substring = a.substring(0, length - 5);
        System.out.println("substring = " + substring);
        String substring2 = a.substring(length - 5+1,length);
        System.out.println("substring2 = " + substring2);
        System.out.println("length = " + length);

        String a1 = "";
        String substring1 = a1.substring(0, 3);
        System.out.println("substring1 = " + substring1);

    }
    @Test
    public void testReplace(){
        String a = "";
        String s = a.replaceAll("\n", " ");
        System.out.println("s = " + s);
        String s1 = s.replaceAll("\t", " ");
        System.out.println("s1 = " + s1);
    }
    @Test
    public void test(){
        String s = "2017-09-01/2021-08-20";
        String now = "2017-09-26";
        String[] flightDates = s.split("/");
        System.out.println("flightDates = " + Arrays.asList(flightDates));
        System.out.println("flightDates = " + now.compareTo(flightDates[0]));
        System.out.println("flightDates = " + now.compareTo(flightDates[1]));
    }

    @Test
    public void test2(){
        String s = "2017-09-26/2017-09-26";
        String now = "2017-09-26 12:00:00";
        String[] flightDates = s.split("/");
        System.out.println("flightDates = " + Arrays.asList(flightDates));
        System.out.println("flightDates = " + now.compareTo(flightDates[0]));
        System.out.println("flightDates = " + now.compareTo(flightDates[1]));
    }

    @Test
    public void test3(){
        String s = "2017-09-25/2017-09-27";
        String now = "2017-09-26 12:00:00";
        String[] flightDates = s.split("/");
        System.out.println("flightDates = " + Arrays.asList(flightDates));
        System.out.println("flightDates = " + now.compareTo(flightDates[0]));
        System.out.println("flightDates = " + now.compareTo(flightDates[1]));
    }


    @Test
    public void testContains(){
        String s = "3U,ZH";
        boolean zh = s.contains("ZH");
        System.out.println("zh = " + zh);

    }
}