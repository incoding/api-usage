package com.javaapi.test.pattern.action.chain2;


public interface Filter {
    public void doFilter(Request request, Response response,FilterChain chain);

}
