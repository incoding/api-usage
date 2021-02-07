package com.javaapi.test.buisness.datachange.difflog;

import lombok.Data;
import org.javers.core.metamodel.annotation.DiffInclude;
import org.javers.core.metamodel.annotation.PropertyName;
import org.javers.core.metamodel.annotation.TypeName;

import java.util.Date;

/**
 * Created by user on 2020/12/27.
 */
@Data
@TypeName("customType")
public class PledgeLogDO {

    private Long id;

    @PropertyName("customMerchantId")
    @DiffInclude
    private String merchantId;

    @PropertyName("customType")
    @DiffInclude
    private String type;

    private String type2;

    private Date createTime;
    private Date updateTime;

    public PledgeLogDO(String merchantId, String type) {
        this.merchantId = merchantId;
        this.type = type;
    }

    public PledgeLogDO(String merchantId, String type, String type2) {
        this.merchantId = merchantId;
        this.type = type;
        this.type2 = type2;
    }
}

