package com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.CarDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 *  示范使用其他映射辅助当前映射
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {


    @Autowired
    CarMapper carMapper;

    @Test
    public void test() {
        Car car = new Car();
        car.setId(1L);
        car.setCreateTime(new Date());
        CarDto carDto = carMapper.carToCarDto(car);
        System.out.println(carDto);
    }

}
