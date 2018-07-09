package com.javaapi.test.application.safe.xss;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by user on 16/11/23.
 */
public class TestJsoupXss {
    @Test
    public void testBasic() {
        Document document = Jsoup.parse("<div>222</div><script>sss</script>");
        Whitelist basic = Whitelist.basic();
        Cleaner cleaner = new Cleaner(basic);
        Document clean = cleaner.clean(document);
        System.out.println("clean.body() = " + clean.body());
    }

    @Test
    public void testBasicWithImages() throws IOException {
        Document document = Jsoup.parse(new File("/Users/user/Desktop/ueditor.html"), "utf-8");
        Whitelist basic = Whitelist.basicWithImages();
        Cleaner cleaner = new Cleaner(basic);
        Document clean = cleaner.clean(document);
        System.out.println("clean.body() = " + clean.body());
    }
}
