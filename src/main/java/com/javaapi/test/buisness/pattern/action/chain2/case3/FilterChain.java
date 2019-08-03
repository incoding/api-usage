package com.javaapi.test.buisness.pattern.action.chain2.case3;

import java.util.ArrayList;
import java.util.List;

/**
 * refer https://www.jianshu.com/p/8a157cb73434
 */
public class FilterChain {
    public List<Filter> mFilters = new ArrayList<>();


    public FilterChain addFilter(Filter filter){
        mFilters.add(filter);
        return this;
    }

    public String doChainFilter(String content) {
        for(Filter filter : mFilters){
            content = filter.doFilter(content);
        }
        return content;
    }
}
