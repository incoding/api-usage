package com.javaapi.test.util.opensource.reactive.rxjava.observable;

import org.junit.Test;
import org.testng.collections.Lists;
import rx.Observable;

import java.util.List;

/**
 * from 发射的时候是逐个发射
 */
public class ClientFrom {
    @Test
    public void testFromArray(){
        FromArray(new Integer[]{1, 2, 3, 4, 5})
                .subscribe(i -> log("FromArray:" + i));
    }

    @Test
    public void testFromIterable(){
        FromIterable(Lists.newArrayList(1,2,3,4,5))
                .subscribe(i -> log("FromIterable:" + i));
    }

    private void log(String s) {
        System.out.println(s);
    }

    private Observable<Integer> FromArray(Integer[] arrays) {
        return Observable.from(arrays);
    }

    private Observable<Integer> FromIterable(List<Integer> list) {
        return Observable.from(list);
    }
}
