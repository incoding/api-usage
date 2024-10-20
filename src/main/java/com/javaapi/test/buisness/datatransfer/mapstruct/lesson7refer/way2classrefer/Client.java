package com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.way2classrefer;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.CarDto;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.Person;
import org.junit.Test;

import java.util.Date;

/**
 * 示范 引用其他类型映射 方式2
 * http://mapstruct.org/documentation/stable/reference/html/#datatype-conversions
 */
public class Client {
    @Test
    public void test(){
        Car car = new Car();
        car.setCreateTime(new Date());
        car.setId(1L);
        Person driver = new Person();
        driver.setDescription("driver desc2");
        car.setDriver(driver);
        CarDto dto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println("dto = " + dto);

    }
}
