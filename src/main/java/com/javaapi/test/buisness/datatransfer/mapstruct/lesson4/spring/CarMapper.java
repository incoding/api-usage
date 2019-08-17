package com.javaapi.test.buisness.datatransfer.mapstruct.lesson4.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = DateMapper.class, componentModel = "spring")
public interface CarMapper {

    CarDto carToCarDto(Car car);

    void updateCarFromDto(CarDto carDto, @MappingTarget Car car);

}