package com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.converter;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.mapper.DateMapper;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.mapper.DateTimeMapper;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.model.FinanceDO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.model.FinanceVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2020/10/2.
 */
@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, uses = {DateMapper.class, DateTimeMapper.class})
public interface FinanceDateTimeConverter {

    FinanceDateTimeConverter INSTANCE = Mappers.getMapper(FinanceDateTimeConverter.class);

    @Mapping(source = "createTime", target = "createTime", qualifiedByName = {"dateTimeMapper"})
    @Mapping(source = "updateTime", target = "updateTime", qualifiedByName = {"dateMapper"})
    FinanceDO vo2Do(FinanceVO vo);

    @Mapping(source = "createTime", target = "createTime", qualifiedByName = {"dateTimeMapper"})
    @Mapping(source = "updateTime", target = "updateTime", qualifiedByName = {"dateMapper"})
    FinanceVO do2Vo(FinanceDO vo);

}
