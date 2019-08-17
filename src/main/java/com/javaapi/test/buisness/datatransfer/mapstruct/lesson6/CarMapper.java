package com.javaapi.test.buisness.datatransfer.mapstruct.lesson6;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by user on 2019/8/15
 */

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "price", target = "price", numberFormat = "#.00")
    CarDto carToCarDto(Car car);

    @IterableMapping(numberFormat = "#.00")
    List<String> prices(List<Integer> prices);
}