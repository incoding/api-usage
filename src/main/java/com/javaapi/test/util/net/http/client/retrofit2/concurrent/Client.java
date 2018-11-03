package com.javaapi.test.util.net.http.client.retrofit2.concurrent;

import com.javaapi.test.util.net.http.client.retrofit2.get.service.GetRequest_Interface;
import com.javaapi.test.util.net.http.client.retrofit2.get.service.Translation;
import org.junit.Test;
import org.testng.collections.Lists;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * retrofit 使用okhttp , okhttp 底层是有个 executer service 来发送请求的
 * https://blog.csdn.net/brycegao321/article/details/52131932
 *
 * 但是没有等待方法,需要自己做.
 */
public class Client {
    @Test
    public void test() {
        //步骤4:创建Retrofit对象
        GetRequest_Interface request = getGetRequest_interface();
        List<Translation.Content> result = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            invoke(request,result);
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
        Call<Translation> call = request.getCall();

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
