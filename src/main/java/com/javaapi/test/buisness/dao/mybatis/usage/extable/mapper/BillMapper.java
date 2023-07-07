package com.javaapi.test.buisness.dao.mybatis.usage.extable.mapper;

import com.javaapi.test.buisness.dao.mybatis.usage.extable.entity.Bill;
import org.apache.ibatis.annotations.Param;

public interface BillMapper {

    Bill selectByBill(@Param("billId") long billId);
}