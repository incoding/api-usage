package com.javaapi.test.pattern.action.chain2.filterImp;

import com.javaapi.test.pattern.action.chain2.Filter;
import com.javaapi.test.pattern.action.chain2.FilterChain;
import com.javaapi.test.pattern.action.chain2.Request;
import com.javaapi.test.pattern.action.chain2.Response;


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
