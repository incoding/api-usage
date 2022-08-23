package com.javaapi.test.util.net.http.client.retrofit2.concurrent;

import com.javaapi.test.util.net.http.client.retrofit2.get.service.GetRequest_Interface;
import com.javaapi.test.util.net.http.client.retrofit2.get.service.Translation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class RetrofitConcurrentError {
    public RetrofitConcurrentError() {
    }

    void invoke(Call<Translation> call, List<Translation.Content> result) {

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

    GetRequest_Interface getGetRequest_interface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .build();

        // 步骤5:创建 网络请求接口 的实例
        return retrofit.create(GetRequest_Interface.class);
    }
}