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

//    只要类型匹配也默认支持自定义转换
//    default SubTarget subSource2subTarget(SubSource subSource) {
//        if (subSource == null) {
//            return null;
//        }
//        SubTarget subTarget = new SubTarget();
//        subTarget.setResult(!subSource.getDeleted().equals(0));
//        subTarget.setName(subSource.getName()==null?"":subSource.getName()+subSource.getName());
//        return subTarget;
//    }
}
