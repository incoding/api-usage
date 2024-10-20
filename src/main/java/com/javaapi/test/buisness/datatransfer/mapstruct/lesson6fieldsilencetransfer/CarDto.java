package com.javaapi.test.buisness.datatransfer.mapstruct.lesson6fieldsilencetransfer;

import lombok.Data;

import java.util.List;

/**
 * Created by user on 2019/8/14
 */
@Data
public class CarDto {
    private Long id;
    private String createTime;
    private String price;
    private List<String> wheels;
}
