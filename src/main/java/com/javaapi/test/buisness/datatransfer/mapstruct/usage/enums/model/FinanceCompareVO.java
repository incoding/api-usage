package com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.enums.OperateTypeEnum;
import lombok.Data;

/**
 * Created by user on 2020/10/2.
 */
@Data
public class FinanceCompareVO {

    private String price;

    private String createTime;

    private String updateTime;

    private Integer operateType;

    public void setOperateType(OperateTypeEnum operateType) {
        this.operateType = operateType.getCode();
    }
}
