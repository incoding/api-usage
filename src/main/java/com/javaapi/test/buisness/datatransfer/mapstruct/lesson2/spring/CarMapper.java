package com.javaapi.test.buisness.datatransfer.mapstruct.lesson2.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2.CarDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class,componentModel = "spring")
public interface CarMapper {

    CarDto carToCarDto(Car car);
}