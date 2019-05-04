package com.javaapi.test.test.javafeature.version8.streams.streamreduce;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 Created by user on 2019/5/2
 */
public class ClientReduce2 {

    /**
     *  单线程执行 不会执行combiner
     */
    @Test
    public void test() {
        String[] strArray = { "abc", "mno", "xyz" };
        List<String> strList = Arrays.asList(strArray);

        System.out.println("stream test");
        int streamResult = strList.stream().reduce(0, (total, s) -> {
            int i = s.codePointAt(0);
            System.out.println("s=" + s + " i = " + i);
            System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + i + "]");
            return total + i;
        }, (a, b) -> {
            System.out.println("combiner: a[" + a + "] b[" + b + "]");
            return 1000000;
        });
        System.out.println("streamResult: " + streamResult);
    }

    @Test
    public void testReduce3() {
        String[] strArray = { "abc", "mno", "xyz" };
        List<String> strList = Arrays.asList(strArray);
        System.out.println("parallelStream test2");
        int parallelStreamResult2 = strList.parallelStream().reduce(0, (total, s) -> {
            System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + s.codePointAt(0) + "]");
            return total + s.codePointAt(0);
        }, (a, b) -> {
            System.out.println("combiner: a[" + a + "] b[" + b + "] a+b[" + (a + b) + "]");
            return a + b;
        });
        System.out.println("parallelStreamResult2: " + parallelStreamResult2);
    }

    @Test
    public void testReduce2() {
        String[] strArray = { "abc", "mno", "xyz","xyz" };
        List<String> strList = Arrays.asList(strArray);
        System.out.println("parallelStream test");
        int parallelStreamResult = strList.parallelStream().reduce(0, (total, s) -> {
            System.out.println("accumulator: total[" + total + "] s[" + s + "] s.codePointAt(0)[" + s.codePointAt(0) + "]");
            return total + s.codePointAt(0);
        }, (a, b) -> {
            System.out.println("combiner: a[" + a + "] b[" + b + "]");
            return a+b;
        });
        System.out.println("parallelStreamResult: " + parallelStreamResult);
    }

    //    @Test
    //    public void test(){
    //        int sumOfWeights = widgets.stream()
    //                .reduce(0,
    //                        (sum, b) -> sum + b.getWeight())
    //        Integer::sum);
    //
    //    }

    @Test public void test2() {
        List<Foo> fooList = Lists.newArrayList(new Foo("A", "san", 1.0, 2), new Foo("A", "nas", 13.0, 1)
                //                new Foo("B","san",112.0,3),
                //                new Foo("C","san",43.0,5),
                //                new Foo("B","nas",77.0,7)
        );
        List<Bar> barList = Lists.newArrayList();
        fooList.stream().collect(Collectors.groupingBy(Foo::getName, Collectors.toList())).forEach((String name, List<Foo> fooListByName) -> {
            Bar bar = new Bar();
            bar = fooListByName.stream().reduce(bar, (Bar u, Foo t) -> {
                return u.sum(t);
            }, (Bar u, Bar t) -> {
                System.out.println("u = " + u);
                System.out.println("t = " + t);
                return u;
            });
            System.out.println(bar.toString());
            barList.add(bar);
        });
    }

}
