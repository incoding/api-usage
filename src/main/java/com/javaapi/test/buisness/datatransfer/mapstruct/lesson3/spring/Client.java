package com.javaapi.test.buisness.datatransfer.mapstruct.lesson3.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.lesson3.Address;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson3.DeliveryAddressDto;
import com.javaapi.test.buisness.datatransfer.mapstruct.lesson3.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 示范多实例映射到一个实例
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AddressMapperNative addressMapperNative;

    @Test
    public void test() {
        Person person = new Person();
        person.setDescription("person desc");

        Address address = new Address();
        address.setHouseNo("address hoseno");

        DeliveryAddressDto deliveryAddressDto = addressMapper.personAndAddressToDeliveryAddressDto(person, address);
        System.out.println("deliveryAddressDto = " + deliveryAddressDto);
    }

    @Test
    public void testNative() throws Exception {
        Person person = new Person();
        person.setDescription("person desc");
        DeliveryAddressDto deliveryAddressDto = addressMapperNative.personAndAddressToDeliveryAddressDto(person, 2);
        System.out.println("deliveryAddressDto = " + deliveryAddressDto);
    }
}
