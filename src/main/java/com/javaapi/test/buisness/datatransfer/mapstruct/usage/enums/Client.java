package com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums;

import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.converter.FinanceExpressionConverter;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.converter.FinanceMethodConverter;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.converter.FinanceSetterConverter;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.enums.OperateTypeEnum;
import com.javaapi.test.buisness.datatransfer.mapstruct.usage.enums.model.FinanceCompareVO;
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


    /**
     * 要是 Bean 中有 Enum 类型，需要去对应 DTO 中的String ，需要注意以下几点：
     * Bean 中重写 setType(String type) 方法
     * DTO 中重写 setType(CarType carType) 方法
     * <p>
     * refer https://www.jianshu.com/p/8e820429686e
     */
    @Test
    public void testSetterConverter() {
        FinanceDO vo = new FinanceDO();
        vo.setCreateTime(new Date());
        vo.setUpdateTime(new Date());
        vo.setPrice(BigDecimal.ONE);
        vo.setOperateType(OperateTypeEnum.CREATE);
        FinanceCompareVO financeVO = FinanceSetterConverter.INSTANCE.do2Vo(vo);
        System.out.println("FinanceSetterConverter.INSTANCE.do2Vo(vo) = " + financeVO);
//        FinanceDO financeDO = FinanceSetterConverter.INSTANCE.vo2Do(financeVO);
//        System.out.println("FinanceSetterConverter = " + financeDO);
    }

    /**
     * refer https://blog.csdn.net/maobois/article/details/109931890
     */
    @Test
    public void tesMethodConverter() {
        FinanceDO vo = new FinanceDO();
        vo.setCreateTime(new Date());
        vo.setUpdateTime(new Date());
        vo.setPrice(BigDecimal.ONE);
        vo.setOperateType(OperateTypeEnum.CREATE);
        FinanceCompareVO financeVO = FinanceMethodConverter.INSTANCE.do2Vo(vo);
        System.out.println("FinanceMethodConverter.INSTANCE.do2Vo(vo) = " + financeVO);
        FinanceDO financeDO = FinanceMethodConverter.INSTANCE.vo2do(financeVO);
        System.out.println("FinanceMethodConverter = " + financeDO);
    }
}
