package com.javaapi.test.buisness.datatransfer.mapstruct.lesson2custommethod;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2020/10/2.
 */
@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FinanceAuthorConverter {

    FinanceAuthorConverter INSTANCE = Mappers.getMapper(FinanceAuthorConverter.class);

    @Mapping(target = "author", expression = "java(vo.getFirstName()+\" \"+vo.getLastName())")
    FinanceVO do2Vo(FinanceDO vo);


}
