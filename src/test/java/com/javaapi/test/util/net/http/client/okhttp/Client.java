package com.javaapi.test.util.net.http.client.okhttp;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by user on 2020/5/8
 */
public class Client {

    OkHttpClient client = new OkHttpClient();


    public static final MediaType JSON_TYPE
            = MediaType.parse("application/json; charset=utf-8");

    @Test
    public void testGet() throws IOException {
        Request request = new Request.Builder()
                .url("http://www.baidu.com/")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("result" + response.body().string());
        }
    }

    @Test
    public void testPost() throws IOException {
        HashMap<String, String> map = new HashMap<>();

        RequestBody body = RequestBody.create(JSON_TYPE, JSON.toJSONString(map));
        Request request = new Request.Builder()
                .url("http://fanyi.youdao.com/translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println("response = " + response.body().string());
        }
    }

}
