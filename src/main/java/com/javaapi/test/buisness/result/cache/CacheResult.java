package com.javaapi.test.buisness.result.cache;

import com.javaapi.test.buisness.result.base.BaseResult;

/**
 * Created by user on 2019/3/2
 */
public class CacheResult<T> extends BaseResult<T> {

    private Boolean fromCache = false;

    public Boolean getFromCache() {
        return fromCache;
    }

    public void setFromCache(Boolean fromCache) {
        this.fromCache = fromCache;
    }
}
