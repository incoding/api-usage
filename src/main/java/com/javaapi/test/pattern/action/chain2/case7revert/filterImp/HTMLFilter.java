package com.javaapi.test.pattern.action.chain2.case7revert.filterImp;

import com.javaapi.test.pattern.action.chain2.case7revert.Filter;
import com.javaapi.test.pattern.action.chain2.case7revert.FilterChain;
import com.javaapi.test.pattern.action.chain2.case7revert.Request;
import com.javaapi.test.pattern.action.chain2.case7revert.Response;


/**
 * 过滤HTML中的脚本元素
 * @author lcq
 *
 */
public class HTMLFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response,FilterChain chain) {
        request.requestStr = request.getRequestStr()
                                    .replace("<", "[")
                                    .replace(">", "] --------HTMLFilter");
        System.out.println("htmlfilter before");
        chain.doFilter(request, response, chain);
        System.out.println("htmlfilter after "+(response.responseStr += "--------HTMLFilter"));

    }

}
