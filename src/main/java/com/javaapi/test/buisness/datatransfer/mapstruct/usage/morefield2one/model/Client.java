package com.javaapi.test.buisness.datatransfer.mapstruct.usage.morefield2one.model;

import org.junit.Test;

/**
 * Created by user on 2020/10/3.
 */
public class Client {

    @Test
    public void testUseDateConverter() {
        FinanceDO vo = new FinanceDO();
        vo.setFirstName("firstname");
        vo.setLastName("lastname");
        FinanceVO financeVO = FinanceAuthorConverter.INSTANCE.do2Vo(vo);
        System.out.println("financeVO = " + financeVO);
    }


}
