package com.javaapi.test.buisness.datatransfer.mapstruct.usage.date.converter;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.model.FinanceDO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.model.FinanceVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2020/10/2.
 */
@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FinanceConverter {
    FinanceConverter INSTANCE = Mappers.getMapper(FinanceConverter.class);

    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "price", target = "price", numberFormat = "#0.00")
    FinanceDO vo2Do(FinanceVO vo);

    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "price", target = "price", numberFormat = "#0.00")
    FinanceVO do2Vo(FinanceDO vo);

}
