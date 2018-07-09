package com.javaapi.test.testUtil.net.http.client.retrofit2.concurrent;

import com.javaapi.test.testUtil.net.http.client.retrofit2.get.service.GetRequest_Interface;
import com.javaapi.test.testUtil.net.http.client.retrofit2.get.service.Translation;
import org.junit.Test;
import org.testng.collections.Lists;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 这是一个错误的用例
 * 用来展示retrofit的错误用法
 *
 * 如果多次调用同一个call
 *
 * java.lang.IllegalStateException: Already executed.

 */
public class ClientError {
    @Test
    public void test() {
        //步骤4:创建Retrofit对象
        GetRequest_Interface request = getGetRequest_interface();
        List<Translation.Content> result = Lists.newArrayList();
        Call<Translation> call = request.getCall();
        for (int i = 0; i < 10; i++) {
            //对 发送请求 进行封装
            invoke(call,result);
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
        call.enqueue(new Callback<Translation>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：处理返回的数据结果
                Translation.Content content = response.body().getContent();
                result.add(content);
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });
    }

    private GetRequest_Interface getGetRequest_interface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        return retrofit.create(GetRequest_Interface.class);
    }
}
