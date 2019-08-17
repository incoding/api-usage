package com.javaapi.test.buisness.datatransfer.mapstruct.lesson9;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.PersonDto;
import lombok.Data;

/**
 * Created by user on 2019/8/14
 */
@Data
public class CarDto {
    private Long id;
    private String createTime;
    private String price;
}
