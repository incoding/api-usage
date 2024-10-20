package com.javaapi.test.buisness.datatransfer.mapstruct.lesson4assamble.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson2converter.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = DateMapper.class, componentModel = "spring")
public interface CarMapper {

    CarDto carToCarDto(Car car);

    void updateCarFromDto(CarDto carDto, @MappingTarget Car car);

}