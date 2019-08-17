package com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.way1;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.CarDto;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.Person;
import org.junit.Test;

import java.util.Date;

/**
 * 示范 引用其他类型映射
 * http://mapstruct.org/documentation/stable/reference/html/#datatype-conversions
 */
public class Client {
    @Test
    public void test(){
        Car car = new Car();
        car.setCreateTime(new Date());
        car.setId(1L);
        Person driver = new Person();
        driver.setDescription("driver desc");
        car.setDriver(driver);
        CarDto dto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println("dto = " + dto);

    }
}
