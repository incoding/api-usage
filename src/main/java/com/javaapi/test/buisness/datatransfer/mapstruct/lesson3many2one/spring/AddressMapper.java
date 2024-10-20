package com.javaapi.test.buisness.datatransfer.mapstruct.lesson3many2one.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson3many2one.Address;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson3many2one.DeliveryAddressDto;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson3many2one.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by user on 2019/8/14
 */
@Mapper(componentModel = "spring")
public interface AddressMapper {
    @Mapping(source = "person.description", target = "description")
    @Mapping(source = "address.houseNo", target = "houseNumber")
    DeliveryAddressDto personAndAddressToDeliveryAddressDto(Person person, Address address);
}
