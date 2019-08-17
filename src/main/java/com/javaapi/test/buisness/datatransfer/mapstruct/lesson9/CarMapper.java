package com.javaapi.test.buisness.datatransfer.mapstruct.lesson9;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by user on 2019/8/15
 */
@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Set<String> integerSetToStringSet(Set<Integer> integers);

    Set<String> integerSetToStringStream(Stream<Integer> integers);

    List<CarDto> carsToCarDtos(List<Car> cars);

    CarDto carToCarDto(Car car);
}