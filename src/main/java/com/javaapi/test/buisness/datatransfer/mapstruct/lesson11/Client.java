package com.javaapi.test.buisness.datatransfer.mapstruct.lesson11;

import org.junit.Test;

/**
 * Created by user on 2019/8/17
 */
public class Client {
    @Test
    public void test(){
        ExternalOrderType externalOrderType = OrderMapper.INSTANCE.orderTypeToExternalOrderType(OrderType.EXTRA);
        System.out.println("externalOrderType = " + externalOrderType);
        ExternalOrderType externalOrderType2 = OrderMapper.INSTANCE.orderTypeToExternalOrderType(OrderType.NORMAL);
        System.out.println("externalOrderType2 = " + externalOrderType2);
        ExternalOrderType externalOrderType3 = OrderMapper.INSTANCE.orderTypeToExternalOrderType(OrderType.STANDARD);
        System.out.println("externalOrderType3 = " + externalOrderType3);

    }
}
