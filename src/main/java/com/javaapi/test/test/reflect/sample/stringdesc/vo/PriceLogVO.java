package com.javaapi.test.test.reflect.sample.stringdesc.vo;

import com.javaapi.test.test.reflect.sample.stringdesc.annotation.LogDesc;
import lombok.Data;


@Data
public class PriceLogVO {
    @LogDesc(order = 1)
    public String resourceType;
    @LogDesc(order = 2)
    private String merchantId;
    @LogDesc(order = 3)
    private String adtPrice;
}
