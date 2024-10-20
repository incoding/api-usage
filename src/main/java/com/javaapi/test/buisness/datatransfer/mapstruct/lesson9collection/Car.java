package com.javaapi.test.buisness.datatransfer.mapstruct.lesson9collection;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by user on 2019/8/14
 */
@Data
public class Car {
    private Long id;
    private Date createTime;
    private BigDecimal price;
}
