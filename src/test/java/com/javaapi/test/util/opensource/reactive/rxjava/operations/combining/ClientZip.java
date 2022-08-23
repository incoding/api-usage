package com.javaapi.test.util.opensource.reactive.rxjava.operations.combining;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * 俩个不同接口数据合并 (好)
 * http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2016/0325/4080.html
 *
 * 例子 来自
 * http://mushuichuan.com/2015/12/11/rxjava-operator-4/
 *
 *
 * zip 应用实例
 * zip操作符在Android中的实际使用场景
 * https://blog.csdn.net/johnny901114/article/details/51614927
 */
public class ClientZip {

    /**
     * Zip操作符将多个Observable发射的数据按顺序组合起来，每个数据只能组合一次，而且都是有序的。最终组合的数据的数量由发射数据最少的Observable来决定。
     Rxjava实现了zip和zipWith两个操作符。
     */
    @Test
    public void testZip(){
        Observable<String> stringObservable = zipIterableObserver();
        stringObservable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation()).
                subscribe((s -> System.out.println(s)));
        System.out.println("stringObservable = " + stringObservable);
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testZipWith(){
        Observable<String> stringObservable = zipWithObserver();
        stringObservable.subscribe((s -> System.out.println(s)));
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Observable<String> zipIterableObserver() {
        return Observable.zip(createObserver(2), createObserver(3), createObserver(4), (s, s2, s3) -> s + "-" + s2 + "-" + s3);
    }

    private Observable<String> zipWithObserver() {
        return createObserver(2).zipWith(createObserver(3), (s, s2) -> s + "-" + s2);
    }

    private Observable<String> createObserver(int index) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                for (int i = 1; i <= index; i++) {
                    System.out.println("emitted:" + index + "-" + i);
                    subscriber.onNext(index + "-" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).subscribeOn(Schedulers.newThread());
    }
}
