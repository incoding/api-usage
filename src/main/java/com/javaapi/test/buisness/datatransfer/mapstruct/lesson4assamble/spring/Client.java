package com.javaapi.test.buisness.datatransfer.mapstruct.lesson4assamble.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.CarDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 示范给一个已经存在的实例进行映射
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {


    @Autowired
    CarMapper carMapper;

    @Test
    public void test() {
        CarDto carDto = new CarDto();
        carDto.setId(1L);
        carDto.setCreateTime("2019-08-14");


        Car car = new Car();
        car.setId(2L);
        carMapper.updateCarFromDto(carDto, car);
        System.out.println("car = " + car);
    }

}
