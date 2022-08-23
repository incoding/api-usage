package com.javaapi.test.util.net.http.client.retrofit2.concurrent;

import com.javaapi.test.util.net.http.client.retrofit2.get.service.GetRequest_Interface;
import com.javaapi.test.util.net.http.client.retrofit2.get.service.Translation;
import org.junit.Test;
import org.testng.collections.Lists;

import java.util.List;

/**
 * retrofit 使用okhttp , okhttp 底层是有个 executer service 来发送请求的
 * https://blog.csdn.net/brycegao321/article/details/52131932
 * <p>
 * 但是没有等待方法,需要自己做.
 */
public class Client {
    private final RetrofitConcurrent retrofitConcurrent = new RetrofitConcurrent();

    @Test
    public void test() {
        //步骤4:创建Retrofit对象
        GetRequest_Interface request = retrofitConcurrent.getGetRequest_interface();
        List<Translation.Content> result = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            retrofitConcurrent.invoke(request, result);
        }


//        try {
//            // 等待异步返回
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("result = " + result);
    }

    private void invoke(GetRequest_Interface request, List<Translation.Content> result) {
        //对 发送请求 进行封装

        //步骤6:发送网络请求(异步)
        retrofitConcurrent.invoke(request, result);
    }

    private GetRequest_Interface getGetRequest_interface() {

        // 步骤5:创建 网络请求接口 的实例
        return retrofitConcurrent.getGetRequest_interface();
    }
}
