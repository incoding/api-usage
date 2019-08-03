package com.javaapi.test.buisness.dao.baseDao.impl.mybatisThirdPart2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by user on 16/8/22.
 */
@Service
public class BaseDaoImpl<T> {
    @Autowired
    protected Mapper<T> mapper;

    public T findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
}
