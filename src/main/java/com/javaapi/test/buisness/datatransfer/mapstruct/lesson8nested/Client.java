package com.javaapi.test.buisness.datatransfer.mapstruct.lesson8nested;

import org.junit.Test;

/**
 * 示范 嵌套映射 到一个实例
 */
public class Client {

    @Test
    public void test(){
        Person person = new Person();
        person.setDescription("person desc");
        Address address = new Address();
        address.setHouseNo("address no");
        address.setHouseArea("address area");
        person.setAddress(address);
        DeliveryAddressDto deliveryAddressDto = AddressMapper.INSTANCE.personAndAddressToDeliveryAddressDto(person);
        System.out.println("deliveryAddressDto = " + deliveryAddressDto);

    }

}
