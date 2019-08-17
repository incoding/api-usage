package com.javaapi.test.buisness.datatransfer.mapstruct.lesson8;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Created by user on 2019/8/14
 */
@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(source = "description", target = "description")
    @Mapping(source = "address.houseNo", target = "houseNumber")
    @Mapping(source = "address.houseArea", target = "houseArea")
    DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person);
}
