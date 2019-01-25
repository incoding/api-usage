package com.javaapi.test.pattern.action.chain2.case7revert.filterImp;

import com.javaapi.test.pattern.action.chain2.case7revert.Filter;
import com.javaapi.test.pattern.action.chain2.case7revert.FilterChain;
import com.javaapi.test.pattern.action.chain2.case7revert.Request;
import com.javaapi.test.pattern.action.chain2.case7revert.Response;


public class MyAfterFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {

        System.out.println("myAfterFilter before");
        chain.doFilter(request, response, chain);
        if (true) {
            return;
        }
        System.out.println("myAfterFilter after");
    }

}
