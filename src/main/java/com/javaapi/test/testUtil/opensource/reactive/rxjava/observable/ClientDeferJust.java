package com.javaapi.test.testUtil.opensource.reactive.rxjava.observable;

import org.junit.Test;
import rx.Observable;

/**
 * defer 和 just 发射时候 一起发射
 *
 *Defer操作符只有当有Subscriber来订阅的时候才会创建一个新的Observable对象,也就是说每次订阅都会得到一个刚创建的最新的Observable对象，这可以确保Observable对象里的数据是最新的，其特点我们将在下面和Just进行对比理解。
 */
public class ClientDeferJust {
    /**
     * 输出是 同一时间
     */
    @Test
    public void testJust(){
        Observable<Long> longObservable = JustObserver();
        longObservable.subscribe(time -> log("just:" + time));
        longObservable.subscribe(time -> log("just:" + time));
    }

    /**
     * 输出是 不同时间
     */
    @Test
    public void testDefer(){
        Observable<Long> longObservable = DeferObserver();
        longObservable.subscribe(time -> log("just:" + time));
        longObservable.subscribe(time -> log("just:" + time));
    }

    private void log(String s) {
        System.out.println(s);
    }

    private Observable<Long> JustObserver() {
        return Observable.just(System.currentTimeMillis(),100L,200L);
    }

    private Observable<Long> DeferObserver() {
        return Observable.defer(() -> Observable.just(System.currentTimeMillis(),300L,400L));
    }
}
