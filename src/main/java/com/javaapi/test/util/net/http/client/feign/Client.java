package com.javaapi.test.util.net.http.client.feign;

import com.javaapi.test.util.net.http.client.feign.service.SearchService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import org.junit.Test;

/**
 * Created by user on 18/1/21.
 * https://www.jianshu.com/p/3d597e9d2d67
 */
public class Client {

    @Test
    public void testGet() {
        SearchService searchService = Feign.builder()
                                           .options(new Request.Options(1000, 3500))
                                           .retryer(new Retryer.Default(5000, 5000, 3))
                                           .target(SearchService.class, "https://www.baidu.com");
        String s = searchService.getSearch();
        System.out.println("s = " + s);
    }

    /**
     * kkps 这个 feign 是真难用,或者说文档不怎么清洗,看了半天文档,看不出来个怎么发post请求
     */
    @Test
    public void testPost() {

    }
}
