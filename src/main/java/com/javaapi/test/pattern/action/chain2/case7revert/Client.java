package com.javaapi.test.pattern.action.chain2.case7revert;

import com.javaapi.test.pattern.action.chain2.case7revert.filterImp.HTMLFilter;
import com.javaapi.test.pattern.action.chain2.case7revert.filterImp.SesitiveFilter;
import org.junit.Test;

/**
 * https://isudox.com/2016/06/06/using-chain-of-responsibility-pattern/
 */
public class Client {
    @Test
    public void test() throws Exception {
        String message = "敏感词汇，重庆，<script> 敏感2 :)";
        Request request = new Request();
        request.setRequestStr(message);
        Response response = new Response();
        response.setResponseStr("response");
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SesitiveFilter());

//        FilterChain fc2 = new FilterChain();
//        fc2.addFilter(new FaceFilter());
//        fc.addFilter(fc2);
        fc.doFilter(request, response, fc);
        System.out.println("request = " + request.getRequestStr());
        System.out.println("response = " + response.getResponseStr());
    }
}
