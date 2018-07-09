package com.javaapi.test.testUtil.opensource.reactive.rxjava.scheduler;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * https://www.daidingkang.cc/2017/05/19/Rxjava/
 *
 *
 *
 * 1 在RxJava 中，Scheduler ——调度器，相当于线程控制器，RxJava 通过它来指定每一段代码应该运行在什么样的线程。RxJava 已经内置了几个 Scheduler ，它们已经适合大多数的使用场景：

 Schedulers.immediate(): 直接在当前线程运行，相当于不指定线程。这是默认的 Scheduler。

 Schedulers.newThread(): 总是启用新线程，并在新线程执行操作。

 Schedulers.io(): I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。行为模式和 newThread() 差不多，区别在于 io() 的内部实现是是用一个无数量上限的线程池，可以重用空闲的线程，因此多数情况下 io() 比 newThread() 更有效率。不要把计算工作放在 io() 中，可以避免创建不必要的线程。

 Schedulers.computation(): 计算所使用的 Scheduler。这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作，例如图形的计算。这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。

 另外， Android 还有一个专用的 AndroidSchedulers.mainThread()，它指定的操作将在 Android 主线程运行。




 2 有了以上这几个 Scheduler ，就可以使用 subscribeOn() 和 observeOn() 两个方法来对线程进行控制了。

 subscribeOn(): 指定 subscribe() 所发生的线程，即 Observable.OnSubscribe 被激活时所处的线程。或者叫做事件产生的线程。

 observeOn(): 指定 Subscriber 所运行在的线程。或者叫做事件消费的线程。


 */
public class ClientScheduler {

    /**
     * https://www.daidingkang.cc/2017/05/19/Rxjava/
     * 事实上，这种在 subscribe() 之前写上两句subscribeOn(Scheduler.io()) 和 observeOn(AndroidSchedulers.mainThread()) 的使用方式非常常见，它适用于多数的 『后台线程取数据，主线程显示』的程序策略。
     *
     *
     * subscribeOn  事件产生线程
     * observeOn 事件消费线程
     *
     *
     * observeOn() 指定的是它之后的操作所在的线程。
     * 因此如果有多次切换线程的需求，只要在每个想要切换线程的位置调用一次 observeOn() 即可
     */

    @Test
    public void test(){
        Observable.just(1, 2, 3, 4)
                // 指定 subscribe() 发生在 IO 线程
                .subscribeOn(Schedulers.io())
                //指定 Subscriber 的回调发生在主线程   , 因为是服务器 所以把AndroidSchedulers.mainThread() 换成了 Schedulers.computation()
                .observeOn(Schedulers.computation())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        System.out.println("number:" + number);
                    }
                });
    }

    @Test
    public void test2() throws Exception {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                System.out.println("call thead = " + Thread.currentThread().getName());
                subscriber.onNext("info1 0s");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onNext("info2 2s");

                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                subscriber.onNext("info3 3s");

                try {
                    TimeUnit.MILLISECONDS.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subscriber.onCompleted();
            }
        })

                //指定 subscribe() 发生在 IO 线程
                .subscribeOn(Schedulers.io())
                //指定 Subscriber 的回调发生在主线程   , 因为是服务器 所以把AndroidSchedulers.mainThread() 换成了 Schedulers.computation()
                .observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted thread = " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError thread = " + Thread.currentThread().getName());
                    }

                    @Override
                    public void onNext(String s) {
                        //UI view显示数据
                        System.out.println(s+"     onNext thread = " + Thread.currentThread().getName());
                    }
                });
        TimeUnit.SECONDS.sleep(100);
    }
}
