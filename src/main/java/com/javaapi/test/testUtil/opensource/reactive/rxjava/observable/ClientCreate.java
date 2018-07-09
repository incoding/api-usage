package com.javaapi.test.testUtil.opensource.reactive.rxjava.observable;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.Random;

/**
 * http://mushuichuan.com/2015/12/11/rxjava-operator-1/
 需要注意的一点就是Observable必须调用所有的Subscriber的onComplete方法并且只能调用一次，
 出错的时候调用onError方法也是一样的，
 并且一旦调用后就不能调用Subscriber的任何其他方法了。
 */
public class ClientCreate {

    /**
     *
     */
    @Test
    public void test(){
        createObserver().subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                log("onComplete!");
            }

            @Override
            public void onError(Throwable e) {
                log("onError:" + e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                log("onNext:" + integer);
            }
        });
    }

    private void log(String s) {
        System.out.println(s);
    }

    private Observable<Integer> createObserver() {
        return Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    for (int i = 0; i < 5; i++) {
                        int temp = new Random().nextInt(10);
                        if (temp > 8) {
                            //if value>8, we make an error
                            subscriber.onError(new Throwable("value >8"));
                            break;
                        } else {
                            subscriber.onNext(temp);
                        }
                        // on error,complete the job
                        if (i == 4) {
                            subscriber.onCompleted();
                        }
                    }
                }
            }
        });
    }
}
