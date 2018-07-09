package com.javaapi.test.testUtil.opensource.reactive.rxjava.operations.transform;

import com.google.common.base.Splitter;
import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.List;

/**
 * RxJava包含了大量的操作符。操作符的数量是有点吓人，但是很值得你去挨个看一下，这样你可以知道有哪些操作符可以使用.
 *
 *
 * 操作符可以让你对数据流做任何操作。
 将一系列的操作符链接起来就可以完成复杂的逻辑。代码被分解成一系列可以组合的片段。
 这就是响应式函数编程的魅力。用的越多，就会越多的改变你的编程思维。
 */
public class ClientOperations {
    /**
     * map操作符，就是用来把把一个事件转换为另一个事件的。
     */
    @Test
    public void testMap() {
        // 输入类型 String
        Observable.just("666")
                .map(new Func1<String, Integer>() {

                    // 参数类型 String
                    // 返回类型 Bitmap
                    @Override
                    public Integer call(String filePath) {
                        return getBitmapFromPath(filePath);
                    }
                })
                .subscribe(new Action1<Integer>() {
                    // 参数类型 String
                    @Override
                    public void call(Integer bitmap) { // 参数类型 Bitmap
                        showBitmap(bitmap);
                    }
                });
    }

    /**
     * 可以用lambda 简化
     *
     * @throws Exception
     */
    @Test
    public void testMapLambda() throws Exception {
        // 输入类型 String
        // 返回类型 Integer
        Observable.just("666")
                .map(
                        filePath -> getBitmapFromPath(filePath)
                )
                .subscribe(
                        bitmap -> showBitmap(bitmap)
                );
    }

    /**
     * 进阶的lambda 简化
     *
     * @throws Exception
     */
    @Test
    public void testMapAdvance() throws Exception {
        String value = "Hello, world!";
        Observable.just(value)
                .map(s -> s.hashCode())
                .map(i -> Integer.toString(i))
                .subscribe(s -> System.out.println(s));
    }

    @Test
    public void testFlatMap() throws Exception {
        query("Hello,world!")
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> urls) {
                        return Observable.from(urls);
                    }
                })
                .subscribe(url -> System.out.println(url));
    }

    private Observable<List<String>> query(String s) {
        Observable<List<String>> listObservable = Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                //发射一个"Hello, world!"的String
                List<String> strings = Splitter.on(",").splitToList(s);
                subscriber.onNext(strings);
                //发射完成,这种方法需要手动调用onCompleted，才会回调Observer的onCompleted方法
                subscriber.onCompleted();
            }
        });
        return listObservable;
    }

    private void showBitmap(Integer bitmap) {
        System.out.println("bitmap = " + bitmap);
    }

    private Integer getBitmapFromPath(String filePath) {
        return Integer.valueOf(filePath);
    }
}
