package com.javaapi.test.util.net.http.client.feign.service;

import feign.RequestLine;

/**
 * Created by user on 18/1/21.
 */
public interface SearchService {
    @RequestLine("GET /")

    public String getSearch();

}
