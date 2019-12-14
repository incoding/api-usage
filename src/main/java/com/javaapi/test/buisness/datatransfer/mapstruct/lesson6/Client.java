package com.javaapi.test.buisness.datatransfer.mapstruct.lesson6;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 示范 隐式类型转换
 * http://mapstruct.org/documentation/stable/reference/html/#datatype-conversions
 */
public class Client {
    @Test
    public void test(){
        Car car = new Car();
        car.setCreateTime(new Date());
        car.setId(1L);
        car.setPrice(new BigDecimal("5.4443"));
        car.setWheels(Lists.newArrayList(1, 2, 3, 4));
        CarDto dto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println("dto = " + dto);
    }
}
