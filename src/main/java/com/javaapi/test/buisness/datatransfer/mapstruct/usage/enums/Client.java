package com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.converter.FinanceExpressionConverter;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceDO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceVO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by user on 2020/10/2.
 */
public class Client {

    @Test
    public void testExpressionConverter() {
        FinanceDO vo = new FinanceDO();
        vo.setCreateTime(new Date());
        vo.setUpdateTime(new Date());
        vo.setPrice(BigDecimal.ONE);
        vo.setOperateType(OperateTypeEnum.CREATE);
        FinanceVO financeVO = FinanceExpressionConverter.INSTANCE.do2Vo(vo);
        System.out.println("FinanceConverter.INSTANCE.do2Vo(vo) = " + financeVO);
        FinanceDO financeDO = FinanceExpressionConverter.INSTANCE.vo2Do(financeVO);
        System.out.println("financeDO = " + financeDO);
    }
}
