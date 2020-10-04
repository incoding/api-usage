package com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model;

import lombok.Data;

/**
 * Created by user on 2020/10/2.
 */
@Data
public class FinanceVO {

    private String price;

    private String createTime;

    private String updateTime;

    private Integer operateType;
}
