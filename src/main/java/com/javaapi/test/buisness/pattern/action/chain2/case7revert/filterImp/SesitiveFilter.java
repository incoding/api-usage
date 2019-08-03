package com.javaapi.test.buisness.pattern.action.chain2.case7revert.filterImp;

import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Filter;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.FilterChain;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Request;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Response;


public class SesitiveFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.requestStr = request
                .getRequestStr()
                .replace("敏感", "  ")
                .replace("敏感2", "haha------SesitiveFilter");
        System.out.println("SesitiveFilter before");
        chain.doFilter(request, response, chain);
        System.out.println("SesitiveFilter after"+(response.responseStr += "------SesitiveFilter"));
    }

}
