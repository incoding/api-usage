package com.javaapi.test.pattern.action.chain2.filterImp;

import com.javaapi.test.pattern.action.chain2.Filter;
import com.javaapi.test.pattern.action.chain2.FilterChain;
import com.javaapi.test.pattern.action.chain2.Request;
import com.javaapi.test.pattern.action.chain2.Response;


public class FaceFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request
                .getRequestStr()
                .replace(":)", "^V^-------FaceFilter");
        System.out.println("FaceFilter before");
        chain.doFilter(request, response, chain);
        System.out.println("FaceFilter after" + (response.responseStr += "-------FaceFilter"));
    }

}
