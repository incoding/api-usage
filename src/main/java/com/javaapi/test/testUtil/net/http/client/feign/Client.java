package com.javaapi.test.testUtil.net.http.client.feign;

import com.javaapi.test.testUtil.net.http.client.feign.service.SearchService;
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
    public void test(){
        SearchService searchService = Feign.builder()
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(SearchService.class, "https://www.baidu.com");
        String s = searchService.search();
        System.out.println("s = " + s);
    }
}
