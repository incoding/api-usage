package com.javaapi.test.buisness.dao.mybatis.usage.extable.converter;

import com.javaapi.test.buisness.dao.mybatis.usage.extable.entity.BillExt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface BillConvertor {

    BillConvertor INSTANCE = Mappers.getMapper(BillConvertor.class);

    @Mapping(expression = "java(param.get(\"billUserId\"))", target = "billUserId")
    @Mapping(expression = "java(param.get(\"billUserName\"))", target = "billUserName")
    BillExt map2ext(Map<String, String> param);


//    BillExt map2ext(List<Map<String, String>> param);
}
