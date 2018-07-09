package com.javaapi.test.testUtil.opensource.reactive.rxjava.observable;

import org.junit.Test;
import rx.Observable;

/**
 *  start 是2    count 4
 *  则取的是2 3 4 5
 * Created by user on 18/4/11
 * 初始值 start  (包含)
 * 数目 count
 *
 */
public class ClientRange {
    @Test
    public void test(){
        rangeObserver().subscribe(i -> log(i));
    }

    private void log(Integer i) {
        System.out.println(i);
    }

    private Observable<Integer> rangeObserver() {
        return Observable.range(10, 5);
    }

}
