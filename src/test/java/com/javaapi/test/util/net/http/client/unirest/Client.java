package com.javaapi.test.util.net.http.client.unirest;


import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.junit.Test;

/**
 * Created by user on 2020/5/8
 */
public class Client {

    @Test
    public void testGet() {
        String url = "https://www.baidu.com";
        HttpResponse<String> stringHttpResponse = Unirest.get(url).queryString("i", "nihao").asString();
        System.out.println(stringHttpResponse.getBody());
    }


    @Test
    public void testPost() {
        HttpResponse<JsonNode> jsonResponse = Unirest.post("http://fanyi.youdao.com/translate?doctype=json&jsonversion=&type=&keyfrom=&model=&mid=&imei=&vendor=&screen=&ssid=&network=&abtest=")
                                                     .header("accept", "application/json")
                                                     .queryString("i", "hello")
                                                     .field("i", "hello")
                                                     .asJson();

        System.out.println("jsonResponse = " + jsonResponse.getBody().toString());
    }
}
