package com.javaapi.test.testUtil.net.http.client.retrofit2.rxjava;

import com.javaapi.test.testUtil.net.http.client.retrofit2.rxjava.service.PostRequest_Interface;
import com.javaapi.test.testUtil.net.http.client.retrofit2.rxjava.service.Translation1;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Retrofit2 与 rxjava1 一起使用
 */
public class Client {
    @Test
    public void test() {
        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Observable<Translation1> call = request.getCall("hello");
        call.subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Translation1>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.err.println("onError");
                    }

                    @Override
                    public void onNext(Translation1 translation1) {
                        System.out.println(translation1);

                    }
                });
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
