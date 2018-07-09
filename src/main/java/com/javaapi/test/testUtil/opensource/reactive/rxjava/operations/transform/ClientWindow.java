package com.javaapi.test.testUtil.opensource.reactive.rxjava.operations.transform;


import org.junit.Test;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * refer http://mushuichuan.com/2015/12/11/rxjava-operator-2/
 *Window操作符类似于我们前面讲过的buffer，不同之处在于window发射的是一些小的Observable对象，由这些小的Observable对象来发射内部包含的数据。同buffer一样，window不仅可以通过数目来分组还可以通过时间等规则来分组
 */
public class ClientWindow {
    @Test
    public void testWindowCountObserver(){
        windowCountObserver().subscribe(i -> {
            log(i);
            i.subscribe((j -> log("window:" + j)));
        });
    }
    @Test
    public void testWondowTimeObserver(){
        wondowTimeObserver().subscribe(i -> {
            log(i);
            i.subscribe((j -> log("window:" + j)));
        });
    }

    private void log(Object i) {
        System.out.println("i = " + i);
    }

    private Observable<Observable<Integer>> windowCountObserver() {
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9).window(3);
    }

    private Observable<Observable<Long>> wondowTimeObserver() {
        return Observable.interval(1000, TimeUnit.MILLISECONDS)
                .window(3000, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.computation());
    }
}
