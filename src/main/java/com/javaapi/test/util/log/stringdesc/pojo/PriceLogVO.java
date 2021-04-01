package com.javaapi.test.util.log.stringdesc.pojo;

import com.javaapi.test.util.log.stringdesc.annotation.LogDesc;

/**
 * Created by user on 2021/4/1.
 */

public class PriceLogVO {
    @LogDesc(order = 1, name = "资源类型")
    public String resourceType;
    @LogDesc(order = 2, name = "供应商")
    private String merchantId;

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
