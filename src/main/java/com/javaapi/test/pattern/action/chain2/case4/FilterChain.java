package com.javaapi.test.pattern.action.chain2.case4;

import com.javaapi.test.pattern.action.chain2.case3.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/14
 */
public class FilterChain implements Filter {
    public List<Filter> mFilters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        mFilters.add(filter);
        return this;
    }

    @Override
    public String doFilter(String content) {
        for (Filter filter : mFilters) {
            content = filter.doFilter(content);
        }
        return content;
    }
}
