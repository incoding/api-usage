package com.javaapi.test.testUtil.opensource.reactive.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * https://www.daidingkang.cc/2017/05/19/Rxjava/
 */
public class ClientHelloWorld {


    /**
     * hello world
     */
    @Test
    public void testSubscribe() {
        // 事件 可观察对象
        Observable<String> myObservable = getObservable();
        // 订阅对象
        Subscriber<String> mySubscriber = getSubscriber();
        // 事件与订阅建立关系,并且发布事件, 调用几次就是发布几次事件
        myObservable.subscribe(mySubscriber);
        myObservable.subscribe(mySubscriber);
    }

    @Test
    public void testUnSubscribe() {
    }

    /**
     * observalbe 种类
     * @throws Exception
     */
    @Test
    public void observable() throws Exception {
        // 1.使用just( )，将为你创建一个Observable并自动为你调用onNext( )发射数据：
        //依次发送"just1"和"just2"
        Observable<String> just = Observable.just("just1", "just2");

        //2.使用from( )，遍历集合，发送每个item：
        List<String> list = new ArrayList<>();
        list.add("from1");
        list.add("from2");
        list.add("from3");
        //遍历list 每次发送一个
        Observable fromObservable = Observable.from(list);

        //3.使用defer( )，有观察者订阅时才创建Observable，并且为每个观察者创建一个新的Observable：
        Observable deferObservable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            //注意此处的call方法没有Subscriber参数
            public Observable<String> call() {
                return Observable.just("deferObservable");
            }});

        //4.使用interval( ),创建一个按固定时间间隔发射整数序列的Observable，可用作定时器：
        //每隔一秒发送一次
        Observable intervalObservable = Observable.interval(1, TimeUnit.SECONDS);

        //5.使用range( ),创建一个发射特定整数序列的Observable，第一个参数为起始值，第二个为发送的个数，如果为0则不发送，负数则抛异常：
        //将发送整数10，11，12，13，14
        Observable rangeObservable = Observable.range(10, 5);

        //6.使用timer( ),创建一个Observable，它在一个给定的延迟后发射一个特殊的值，等同于Android中Handler的postDelay( )方法：
        //3秒后发射一个值
        Observable timeObservable = Observable.timer(3, TimeUnit.SECONDS);

        //7.使用repeat( ),创建一个重复发射特定数据的Observable:
        //重复发射3次
        Observable repeatObservable = Observable.just("repeatObservable").repeat(3);
    }

    @Test
    public void subscriber() throws Exception {
        Observable<String> observable = getObservable();
        // 1 放入action 即可
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        };
        Subscription subscribe = observable.subscribe(onNextAction);

        //2 lambda
        Observable.just("Hello, world!")
                .subscribe(s -> System.out.println(s));
    }

    /**
     * Action0 是 RxJava 的一个接口，它只有一个方法 call()，这个方法是无参无返回值的；由于 onCompleted() 方法也是无参无返回值的，因此 Action0 可以被当成一个包装对象，将 onCompleted() 的内容打包起来将自己作为一个参数传入 subscribe() 以实现不完整定义的回调。这样其实也可以看做将onCompleted() 方法作为参数传进了 subscribe()，相当于其他某些语言中的『闭包』。
     * Action1 也是一个接口，它同样只有一个方法 call(T param)，这个方法也无返回值，但有一个参数；与 Action0 同理，由于 onNext(T obj) 和 onError(Throwable error)也是单参数无返回值的，因此 Action1 可以将 onNext(obj) 和 onError(error) 打包起来传入 subscribe() 以实现不完整定义的回调。
     * @throws Exception
     */
    @Test
    public void name() throws Exception {

    }

    private Observable<String> getObservable() {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //发射一个"Hello, world!"的String
                subscriber.onNext("Hello, world!");
                //发射完成,这种方法需要手动调用onCompleted，才会回调Observer的onCompleted方法
                subscriber.onCompleted();
            }
        });
    }

    private Subscriber<String> getSubscriber() {
        return new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                //打印出"Hello, world!"
                System.out.println(s);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }
        };
    }
}
