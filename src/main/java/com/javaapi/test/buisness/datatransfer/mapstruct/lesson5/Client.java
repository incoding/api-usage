package com.javaapi.test.buisness.datatransfer.mapstruct.lesson5;

import org.junit.Test;

import java.util.Date;

/**
 * 示范非spring环境,如何使用
 * http://mapstruct.org/documentation/stable/reference/html/#datatype-conversions
 */
public class Client {
    @Test
    public void test(){
        Car car = new Car();
        car.setCreateTime(new Date());
        car.setId(1L);
        CarDto dto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println("dto = " + dto);

    }
}
