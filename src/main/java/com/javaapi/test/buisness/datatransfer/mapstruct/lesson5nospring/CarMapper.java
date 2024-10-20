package com.javaapi.test.buisness.datatransfer.mapstruct.lesson5nospring;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2019/8/14
 */
@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto carToCarDto(Car car);
}