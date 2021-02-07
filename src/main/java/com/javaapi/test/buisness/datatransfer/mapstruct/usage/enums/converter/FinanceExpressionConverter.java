package com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.converter;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceDO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2020/10/2.
 */
@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FinanceExpressionConverter {

    FinanceExpressionConverter INSTANCE = Mappers.getMapper(FinanceExpressionConverter.class);

    /**
     * java() 内就是普通的调用
     *
     * @param vo
     * @return
     */
    @Mapping(target = "operateType", expression = "java(com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.enums.OperateTypeEnum.getEnumByCode(vo.getOperateType()))")
    FinanceDO vo2Do(FinanceVO vo);

    @Mapping(target = "operateType", expression = "java(vo.getOperateType().getCode())")
    FinanceVO do2Vo(FinanceDO vo);

}
