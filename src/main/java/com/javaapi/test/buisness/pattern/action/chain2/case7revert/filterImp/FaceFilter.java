package com.javaapi.test.buisness.pattern.action.chain2.case7revert.filterImp;

import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Filter;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.FilterChain;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Request;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Response;


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
