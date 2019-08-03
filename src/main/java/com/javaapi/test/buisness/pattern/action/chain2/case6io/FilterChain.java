package com.javaapi.test.buisness.pattern.action.chain2.case6io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2019/1/18
 */
public class FilterChain implements Filter {
    public List<Filter> mFilters = new ArrayList<>();


    public FilterChain addFilter(Filter filter) {
        mFilters.add(filter);
        return this;
    }


    @Override
    public void doFilter(Request request, Response response) {
        for (Filter filter : mFilters) {
            filter.doFilter(request, response);
        }
    }
}