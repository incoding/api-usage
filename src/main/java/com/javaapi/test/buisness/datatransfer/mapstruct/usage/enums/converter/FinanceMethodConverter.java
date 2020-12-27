package com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.converter;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.enums.OperateTypeEnum;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceCompareVO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceDO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2020/10/2.
 */
@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface FinanceMethodConverter {

    FinanceMethodConverter INSTANCE = Mappers.getMapper(FinanceMethodConverter.class);

    FinanceCompareVO do2Vo(FinanceDO vo);


    FinanceDO vo2do(FinanceCompareVO vo);

    //枚举类字段转换
    default OperateTypeEnum customConveter(int operateType) {
        return OperateTypeEnum.getEnumByCode(operateType);
    }

    default int customConveter(OperateTypeEnum operateType) {
        return operateType.getCode();
    }
}
