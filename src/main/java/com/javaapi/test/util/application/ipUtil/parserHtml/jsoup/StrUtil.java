package com.javaapi.test.util.application.ipUtil.parserHtml.jsoup;

import com.steadystate.css.parser.CSSOMParser;
import com.steadystate.css.parser.SACParserCSS3;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSStyleDeclaration;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by user on 16/11/22.
 */
public class StrUtil {

    private static final Logger logger = LoggerFactory.getLogger(StrUtil.class);

    private static final String[] tagRemove = {"style","link"};
    private static final String[] attrRemove = {"width","min-width","max-width"};
    private static final String[] cssInStyleRemove = {"width"};
    /**
     *  管理员发的文章原样输出
     * @return
     */
    public static String removeIlleaglString(String txt) {
        try {
            final Document parse = Jsoup.parse(txt);
            Stream<String> stream = Arrays.stream(tagRemove);
            stream.forEach((s)-> {
                parse.getElementsByTag(s).remove();
            });
            Stream<String> streamAttr = Arrays.stream(attrRemove);
            streamAttr.forEach((s)->{
                parse.getElementsByAttribute(s).removeAttr(s);
            });
            removeCssInStyle(parse);
            return parse.body().html();
        } catch (Exception e) {
            logger.warn("过滤文章时候发生异常",e);
            return txt;
        }
    }
    private static void removeCssInStyle(Document parse){
        Elements style = parse.getElementsByAttribute("style");
        for (String cssNeedRemove : cssInStyleRemove) {
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
                decl.removeProperty(cssNeedRemove);
                s.attr("style", decl.getCssText());
            });
        }
    }


}
