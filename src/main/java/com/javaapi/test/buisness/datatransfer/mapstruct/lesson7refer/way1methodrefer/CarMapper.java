package com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.way1methodrefer;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.Car;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.CarDto;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.Person;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.PersonDto;
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