package com.javaapi.test.buisness.datatransfer.mapstruct.lession2and1;

import org.junit.Test;

/**
 * 测试 自定义方法
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
