package com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.converter.FinanceDateTimeConverter;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.model.FinanceDO;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.qulified.model.FinanceVO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 有多个源和目标类型都匹配的话需要指定具体使用哪个个映射
 * Created by user on 2020/10/3.
 */
public class Client {

    @Test
    public void testUseDateConverter() {
        FinanceDO vo = new FinanceDO();
        vo.setCreateTime(new Date());
        vo.setUpdateTime(new Date());
        vo.setPrice(BigDecimal.ONE);
        FinanceVO financeVO = FinanceDateTimeConverter.INSTANCE.do2Vo(vo);
        System.out.println("FinanceConverter.INSTANCE.do2Vo(vo) = " + financeVO);
        FinanceDO financeDO = FinanceDateTimeConverter.INSTANCE.vo2Do(financeVO);
        System.out.println("financeDO = " + financeDO);
    }

}
