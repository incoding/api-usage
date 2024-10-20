package com.javaapi.test.buisness.datatransfer.mapstruct.lesson11enum;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2019/8/17
 */
@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @ValueMappings({
            @ValueMapping(source = "EXTRA", target = "SPECIAL"),
            @ValueMapping(source = "STANDARD", target = "DEFAULT"),
            @ValueMapping(source = "NORMAL", target = "DEFAULT")
    })
    ExternalOrderType orderTypeToExternalOrderType(OrderType orderType);
}
