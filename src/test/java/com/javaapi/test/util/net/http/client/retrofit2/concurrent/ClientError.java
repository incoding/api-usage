package com.javaapi.test.util.net.http.client.retrofit2.concurrent;

import com.javaapi.test.util.net.http.client.retrofit2.get.service.GetRequest_Interface;
import com.javaapi.test.util.net.http.client.retrofit2.get.service.Translation;
import org.junit.Test;
import org.testng.collections.Lists;
import retrofit2.Call;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 这是一个错误的用例
 * 用来展示retrofit的错误用法
 * <p>
 * 如果多次调用同一个call
 * <p>
 * java.lang.IllegalStateException: Already executed.
 */
public class ClientError {
    private final RetrofitConcurrentError retrofitConcurrentError = new RetrofitConcurrentError();

    @Test
    public void test() {
        //步骤4:创建Retrofit对象
        GetRequest_Interface request = retrofitConcurrentError.getGetRequest_interface();
        List<Translation.Content> result = Lists.newArrayList();
        Call<Translation> call = request.getCall();
        for (int i = 0; i < 10; i++) {
            //对 发送请求 进行封装
            retrofitConcurrentError.invoke(call, result);
        }


        try {
            // 等待异步返回
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result = " + result);
    }

    private void invoke(Call<Translation> call, List<Translation.Content> result) {

        //步骤6:发送网络请求(异步)
        retrofitConcurrentError.invoke(call, result);
    }

    private GetRequest_Interface getGetRequest_interface() {

        // 步骤5:创建 网络请求接口 的实例
        return retrofitConcurrentError.getGetRequest_interface();
    }
}
