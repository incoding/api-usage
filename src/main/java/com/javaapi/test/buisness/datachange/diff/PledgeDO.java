package com.javaapi.test.buisness.datachange.diff;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by user on 2020/12/27.
 */
@Data
public class PledgeDO {
    private Long id;
    private String merchantId;
    private String type;
    private Date createTime;
    private Date updateTime;

    public PledgeDO(String merchantId, String type) {
        this.merchantId = merchantId;
        this.type = type;
    }
}

