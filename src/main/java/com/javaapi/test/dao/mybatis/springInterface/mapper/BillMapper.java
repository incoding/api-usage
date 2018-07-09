package com.javaapi.test.dao.mybatis.springInterface.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.javaapi.test.dao.mybatis.springInterface.domain.Bill;

public interface BillMapper {
	List<Map<String, String>> selectAll();

	Map<String, String> selectBill(@Param("billid") long billid);

	Map<String, String> selectBillMap(Map<String, Object> map);
	
	Bill selectBillObject(Bill bill);
}