package com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.way1;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.CarDto;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.Person;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2019/8/14
 */
@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto carToCarDto(Car car);

    PersonDto personToPersonDto(Person person);

}