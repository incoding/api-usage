package com.javaapi.test.application.safe.xss;

import org.junit.Test;
import org.owasp.validator.html.*;

import java.io.File;

/**
 * owasp防止xss漏洞做的是比较全面的,对富文本编辑器也比较友好
 */
public class TestOWASP {
    private static Policy policy = null;
    private static final AntiSamy antiSamy = new AntiSamy();


    static {
        try {
            File file = new File(TestOWASP.class.getClassLoader().getResource("antisamy.xml").getPath());
            if (file.exists()) {
                policy = Policy.getInstance(file);
            }
        } catch (PolicyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
            String illegal = "<IMG SRC=javascript:alert('XSS')>";
            CleanResults scan = antiSamy.scan(illegal + " <div>nihao</div>", policy);
            String cleanHTML = scan.getCleanHTML();
            System.out.println("cleanHTML = " + cleanHTML);
        } catch (ScanException e) {
            e.printStackTrace();
        } catch (PolicyException e) {
            e.printStackTrace();
        }

    }

    /**
     * 无xss得富文本编辑器内容可以正常显示
     */
    @Test
    public void test2() {
        try {
            String illegal = "<p>\n" +
                    "    <span style=\"font-size: 24px;\"><strong><span style=\"color:#ff0000\"><strong style=\"font-style: normal; font-size: 24px; font-family: &quot;Helvetica Neue&quot;, Helvetica, Arial, STHeiti, &quot;Microsoft Yahei&quot;, sans-serif; white-space: normal;\"><span style=\"font-size: 24px; color: rgb(255, 0, 0); background-color: rgb(0, 176, 80);\">可爱小狗狗</span></strong></span></strong></span>\n" +
                    "</p>";
            CleanResults scan = antiSamy.scan(illegal + " <div>nihao</div>", policy);
            String cleanHTML = scan.getCleanHTML();
            System.out.println("cleanHTML = " + cleanHTML);
        } catch (ScanException e) {
            e.printStackTrace();
        } catch (PolicyException e) {
            e.printStackTrace();
        }

    }

    /**
     * 既有xss也有正常的style,也能显示出正常的内容
     * 注意!! 自定义内容会被过滤掉....
     */
    @Test
    public void test3() {
        try {
            String illegal = "<div style='background:url(javascript:alert(1));color:#ff0000;' ww='你好' >你好</div>";
            CleanResults scan = antiSamy.scan(illegal + " <div>nihao</div>", policy);
            String cleanHTML = scan.getCleanHTML();
            System.out.println("cleanHTML = " + cleanHTML);
        } catch (ScanException e) {
            e.printStackTrace();
        } catch (PolicyException e) {
            e.printStackTrace();
        }

    }


}
