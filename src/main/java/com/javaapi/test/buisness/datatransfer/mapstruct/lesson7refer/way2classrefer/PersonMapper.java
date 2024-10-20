package com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.way2classrefer;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.Person;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson7refer.PersonDto;
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