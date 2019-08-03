package com.javaapi.test.buisness.dao.baseDao.impl.mybatisImpl;

import com.javaapi.test.buisness.dao.baseDao.base.IBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 16/8/2.
 */
@Component
public abstract class BaseDaoImpl<T,ID extends Serializable> implements IBaseDao<T,ID>{

    @Autowired
    Mapper<T> mapper;

    @Override
    public T findById(ID id) {
        return mapper.selectByPrimaryKey(id);
    }




    @Override
    public List<T> findAll(List<ID> id) {
        return null;
    }

    @Override
    public Page<T> findAll(T t, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public Page<T> findAll(T t, Pageable pageable) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public int deleteById(ID id) {
        return 0;
    }

    @Override
    public int deleteByIds(List<ID> ids) {
        return 0;
    }

    @Override
    public ID saveRID(T t) {
        return (ID)Integer.valueOf(0);
    }

    @Override
    public int save(List<T> ts) {
        return 0;
    }

    @Override
    public int updateDynamic(T t) {
        return 0;
    }

    @Override
    public int updateRRC(T t) {
        return 0;
    }
}
