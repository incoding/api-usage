package com.javaapi.test.util.opensource.guava.string;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * 可以用来切分url 参数
 */
public class TestSplitter {
    @Test
    public void testSplitter() {
        Iterable<String> split = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");
        System.out.println("split = " + split);
    }


    @Test
    public void testSplitter0() {
        Iterable<String> split = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(null);
        System.out.println("split = " + split);
    }
    @Test
    public void testSplitter2() {
        String flightNum = "5125";
        String sequence = "5125/5126-5138";
//        "5125/5126-5138"  斜杠是分隔符,中横岗是代表从5126到5138都匹配
        Iterable<String> split = Splitter.on('/')
                .trimResults()
                .omitEmptyStrings()
                .split(sequence);
        for (String str : split) {
            if (!str.contains("-") && !flightNum.equals(str)) {
                return;
            }else{
                List<String> strings = Splitter.on("-").splitToList("-");
                if (strings.size() < 2) {
                    return;
                }
                int num = Integer.valueOf(flightNum);
                Integer start = Integer.valueOf(strings.get(0));
                Integer end = Integer.valueOf(strings.get(1));
                boolean pass= false;
                for (int i = start; i <= end; i++) {
                    if (num == i) {
                        pass = true;
                        break;
                    }
                }
                if (!pass) {
                    return;
                }
            }
        }

    }

    /**
     * url 转map
     */
    @Test
    public void test(){
        Map<String, String> split = Splitter.on('&')
                .withKeyValueSeparator("=")
                .split("nihao1=nihaovalue&nihao2=nihao2value");
        System.out.println("split = " + split);
        System.out.println("split = " + split.get("nihao1"));

    }
}
