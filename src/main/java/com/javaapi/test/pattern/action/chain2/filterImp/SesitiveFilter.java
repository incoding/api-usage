package com.javaapi.test.pattern.action.chain2.filterImp;

import com.javaapi.test.pattern.action.chain2.Filter;
import com.javaapi.test.pattern.action.chain2.FilterChain;
import com.javaapi.test.pattern.action.chain2.Request;
import com.javaapi.test.pattern.action.chain2.Response;


public class SesitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request.getRequestStr().replace("敏感", "  ")
                .replace("猫猫", "haha------SesitiveFilter");
        chain.doFilter(request, response, chain);
        response.responseStr += "------SesitiveFilter";

    }

}
