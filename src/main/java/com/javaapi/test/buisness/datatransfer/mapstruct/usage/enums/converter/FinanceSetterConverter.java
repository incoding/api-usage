package com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.converter;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceCompareVO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceDO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2020/10/2.
 */
@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FinanceSetterConverter {

    FinanceSetterConverter INSTANCE = Mappers.getMapper(FinanceSetterConverter.class);

//    FinanceDO vo2Do(FinanceCompareVO vo);

    FinanceCompareVO do2Vo(FinanceDO vo);


}
