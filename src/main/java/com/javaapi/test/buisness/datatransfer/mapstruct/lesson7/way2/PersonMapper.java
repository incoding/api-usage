package com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.way2;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.Person;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2019/8/14
 */
@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto personToPersonDto(Person person);

}