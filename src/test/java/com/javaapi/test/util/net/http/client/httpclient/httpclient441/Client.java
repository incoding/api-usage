package com.javaapi.test.util.net.http.client.httpclient.httpclient441;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by user on 18/1/14.
 */
public class Client {

    public static final String url = "https://www.facebook.com";

    @Test
    public void testGet() {
        String s = HttpClientUtil.doGet(url);
        System.out.println("s = " + s);
    }
    @Test
    public void testGetWithParam() {
        HashMap<String, String> map = new HashMap<>();
        String s = HttpClientUtil.doGet(url, map);
        System.out.println("s = " + s);
    }
}
