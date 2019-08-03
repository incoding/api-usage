package com.javaapi.test.test.misc.codegenerator.practice.mapper;


import com.javaapi.test.test.misc.codegenerator.practice.dataobject.OrderDO;

public interface OrderDAO {

    int insert(OrderDO record);

    int updateByPrimaryKeySelective(OrderDO record);

    OrderDO selectByPrimaryKey(Long id);

    OrderDO selectById(Long id);

}