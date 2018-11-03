package com.javaapi.test.util.application.ipUtil.parserHtml.jsoup;

import com.steadystate.css.parser.CSSOMParser;
import com.steadystate.css.parser.SACParserCSS3;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSStyleDeclaration;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

/**
 *
 */
public class Client {
    @Test
    public void testExclude() {
        Document parse = Jsoup.parse("<style>nihoassss</style><div>22222</div>");
        Elements style = parse.getElementsByTag("style");
        System.out.println("style.toString() = " + style.toString());
    }

    @Test
    public void testRemoveTag() {
        Document parse = Jsoup.parse("<style>nihoassss</style><div>22222</div><p><img src=\"/dotnet/date/ueditor/dialogs/emotion/images/ac/35.gif\" />up第一次发帖，现在心里实在是憋不住了，太难受了，大家当笑话看也好，安慰一下也好。</p><p>12年12月份圣诞节左右，up先是滑雪时候给人滑雪板刮了，那人是自带的滑雪板，说是从美国代购的，刃口那刮了两道子，那人就说滑雪切雪什么的全靠刃口，本来我让他把发票拿来，多少钱我直接买了。后来合计一下，一年也就那几个月能滑雪，我也不是那种发烧友，看那人四十左右岁，开的是奔驰GLK，也不想讹钱的，就直接赔了2000块钱。果然是祸不单行，过了一天，圣诞节那天，早晨上班，手机掉出租车上了，我马上回打直接关节，up那也不是啥好手机Htc的DesireZ 就是那个能侧滑的，up喜欢的不行，天天用它玩sfc模拟器，唉，才用了半年，卒。</p><p><img src=\"/dotnet/date/ueditor/dialogs/emotion/images/ac/38.gif\" />然后13年平平安安一年，没出啥事，到了14年就挺不住了。1月8号那天，我剑网3里的好基友结婚，两口子从我是小白的时候就带我打本打jjc，认识了两年多关系一直很好。公会会长还有其他两个好基友也要去，认识那么久也没见过，正好算个线下聚会。结婚两口子实在吉林大安，一个小县城，离长春也就200公里，其他三个好基友都是哈尔滨那边的，我是辽宁这边，我们就决定从长春租一个车，开车去大安。到了长春我们几个吃了顿饭唠了唠嗑，感觉跟游戏上一样都挺投缘的。然后要开车去机场接个妹纸，就是司机童鞋的情缘，往机场去的告诉上就出事了，作副驾驶那位管我要来根烟，然后开车那位也要，直接回头管我要火，这时候车左边就刮护栏上了，想想真是作死，当时开了140迈，车头先是直接撞护栏上，然后往右转圈，转了三圈停慢行道了，亏了命大，我们四个啥事没有，不过那车是废了前脸基本上磨平了。。。。。我们几个打了个车去的机场，叫的拖车啥的，我们四个人，我坐副驾驶后边，眼镜框撞到副驾驶座上，碎了，尼玛的我在实体店买的佐川藤井的框子，1200啊，手机从我手里飞出去撞挡风玻璃上，屏碎了（还是htc的 晚茶），他们三个啥事没有<img src=\"/dotnet/date/ueditor/dialogs/emotion/images/ac/34.gif\" />。接完妹子我们几个喝了一顿酒压惊，第二天坐火车去的基友家。婚礼完事up就回家了，直接上网拍了个htc butterfly，这周一邮到的，结果特么今天上班，起晚了，着急忙慌的打车去，下车时候又落车上了，卒。</p><p><br /></p><p>吐槽完了。。。胸口的不痛快少了一大半，为啥up一到年关就那么倒霉啊，我也没做过什么腻，我捡过3次手机，还有次是爱疯4s，我都还给人家了，干啥我一丢手机就碰见无良的人，唉。引以为戒吧，引以为戒。求安慰，求虎摸<img src=\"/dotnet/date/ueditor/dialogs/emotion/images/ac/34.gif\" /></p>");
        parse.getElementsByTag("style").remove();
        System.out.println("style.toString() = " + parse.body().html());
    }

    @Test
    public void testWidth() {
        Document parse = Jsoup.parse("<div width=\"12\" >nihoassss</div><div>22222</div>");
        Elements elementsByAttribute = parse.getElementsByAttribute("width");
        elementsByAttribute.forEach((s) -> {
            System.out.println("s = " + s);
        });
    }

    @Test
    public void testRemoveAttr() {
        Document parse = Jsoup.parse("<div width=\"12\" >nihoassss</div><div>22222</div>");
        parse.getElementsByAttribute("width").removeAttr("width");
        System.out.println("parse = " + parse);
    }

    @Test
    public void testRemoveAttrInStyle() {
        Document parse = Jsoup.parse("<div style=\"width:12;backgroud:url('http://www.baidu.com')\" >nihoassss</div><div>22222</div>");

        Elements style = parse.getElementsByAttribute("style");
        style.forEach((s) -> {
            String styleStr = s.attr("style");


            InputSource source = new InputSource(new StringReader(styleStr));
            CSSOMParser parser = new CSSOMParser(new SACParserCSS3());
            CSSStyleDeclaration decl = null;
            try {
                decl = parser.parseStyleDeclaration(source);
            } catch (IOException e) {
                e.printStackTrace();
            }
            decl.removeProperty("width");
            s.attr("style", decl.getCssText());
        });
        System.out.println("style = " + parse);


    }

    /**
     * 如果css写错了,会抛出异常
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        InputSource source = new InputSource(new StringReader("width:12;backgroud:url('http://www.baidu.com')"));
        CSSOMParser parser = new CSSOMParser(new SACParserCSS3());
        CSSStyleDeclaration decl = parser.parseStyleDeclaration(source);
        String s = decl.removeProperty("width");
        for (int i = 0; i < decl.getLength(); i++) {
            final String propName = decl.item(i);

            System.out.println("'" + propName + "' has value: '" + decl.getPropertyValue(propName) + "'");
        }

        System.out.println("s = " + decl.getCssText());


    }

    @Test
    public void testMinWidth() {
        Document parse = Jsoup.parse("<div min-width=12 >nihoassss</div><div>22222</div>");
        Elements elementsByAttribute = parse.getElementsByAttribute("min-width");
        elementsByAttribute.forEach((s) -> {
            System.out.println("s = " + s);
        });
    }

    @Test
    public void testGetAllElements() throws IOException {
        Document parse = Jsoup.parse(new File("/Users/user/Desktop/ueditor.html"), "utf-8");
        Elements allElements = null;
        allElements = parse.select("*");
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        for (Element allElement : allElements) {
            objectObjectHashMap.put(allElement.tagName(), allElement.tagName());
        }
        objectObjectHashMap.forEach((k, v) -> {
            System.out.println(k);
        });
    }
}
