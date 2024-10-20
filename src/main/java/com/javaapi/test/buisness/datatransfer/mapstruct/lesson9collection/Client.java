package com.javaapi.test.buisness.datatransfer.mapstruct.lesson9collection;

import com.google.common.collect.Sets;
import org.junit.Test;
import org.testng.collections.Lists;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 示范 映射collection
 * http://mapstruct.org/documentation/stable/reference/html/#datatype-conversions
 */
public class Client {
    @Test
    public void test() {
        Car car = new Car();
        car.setCreateTime(new Date());
        car.setId(1L);
        car.setPrice(new BigDecimal("11"));
        List<Car> cars = Lists.newArrayList(car);
        List<CarDto> carDtos = CarMapper.INSTANCE.carsToCarDtos(cars);
        System.out.println("carDtos = " + carDtos);
    }
    @Test
    public void testSet(){
        HashSet<Integer> integers = Sets.newHashSet(1, 2);
        Set<String> strings = CarMapper.INSTANCE.integerSetToStringSet(integers);
        System.out.println("strings = " + strings);
    }

    @Test
    public void testStream(){
        Stream<Integer> integers = Stream.of(1, 2);
        Set<String> strings = CarMapper.INSTANCE.integerSetToStringStream(integers);
        System.out.println("strings = " + strings);
    }

}
