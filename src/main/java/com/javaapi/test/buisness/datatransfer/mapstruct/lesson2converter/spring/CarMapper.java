package com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.CarDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class,componentModel = "spring")
public interface CarMapper {

    CarDto carToCarDto(Car car);
}