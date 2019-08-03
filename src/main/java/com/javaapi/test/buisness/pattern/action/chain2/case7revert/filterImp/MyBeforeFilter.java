package com.javaapi.test.buisness.pattern.action.chain2.case7revert.filterImp;

import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Filter;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.FilterChain;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Request;
import com.javaapi.test.buisness.pattern.action.chain2.case7revert.Response;


public class MyBeforeFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {

        System.out.println("myBeforeFilter before");
        if (true) {
            return;
        }
        chain.doFilter(request, response, chain);
        System.out.println("myBeforeFilter after");
    }

}
