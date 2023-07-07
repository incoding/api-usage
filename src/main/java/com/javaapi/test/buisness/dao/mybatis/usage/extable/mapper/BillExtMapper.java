package com.javaapi.test.buisness.dao.mybatis.usage.extable.mapper;

import com.javaapi.test.buisness.dao.mybatis.usage.extable.entity.KvLine;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BillExtMapper {

    List<KvLine> selectByBill(@Param("billId") long billId);

    @MapKey("key")
    Map<String, KvLine> selectByBizId(@Param("bizId") long bizId);

}