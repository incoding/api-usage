package com.javaapi.test.buisness.datatransfer.mapstruct.usage.date;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.date.converter.FinanceConverter;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.model.FinanceDO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.model.FinanceVO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by user on 2020/10/3.
 */
public class Client {
    @Test
    public void test() {
        FinanceDO vo = new FinanceDO();
        vo.setCreateTime(new Date());
        vo.setPrice(BigDecimal.ONE);
        FinanceVO financeVO = FinanceConverter.INSTANCE.do2Vo(vo);
        System.out.println("FinanceConverter.INSTANCE.do2Vo(vo) = " + financeVO);
        FinanceDO financeDO = FinanceConverter.INSTANCE.vo2Do(financeVO);
        System.out.println("financeDO = " + financeDO);
    }

}
