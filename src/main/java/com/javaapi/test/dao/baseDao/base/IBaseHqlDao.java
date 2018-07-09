package com.javaapi.test.dao.baseDao.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 16/8/2.
 */
public interface IBaseHqlDao<T,ID extends Serializable> extends IBaseDao<T,ID> {
    /**
     * ----hibernate start -----------------------------------------
     */

    /**
     * 按hql 查询 单个实体
     *
     * @param hql
     * @param params
     * @return
     */
    public T findOne(String hql, Map<String, Object> params);

//    public T findOne(String hql, Object... params);
//
//    public T findOne(String hql, List<Object> params);

    /**
     * 按hql进行查询 实体list
     *
     * @param hql
     * @param params
     * @return
     */
    public List<T> findAll(String hql, Map<String, Object> params);

    public Page<T> findAll(String hql, Pageable pageable, Map<String, Object> params);


    /**
     * 按hql进行查询 实体list
     *
     * @param hql
     * @param params
     * @return
     */
//    public List<T> findAll(String hql, Object... params);
//
//    public Page<T> findAll(String hql, Pageable pageable, Object... params);


    /**
     * 按hql进行查询 实体list
     *
     * @param hql
     * @param params
     * @return
     */
//    public List<T> findAll(String hql, List<Object> params);

//    public Page<T> findAll(String hql, Pageable pageable, List<Object> params);

    /**
     * -----hibernate end----------------------------------------
     */

    /**
     * 按id,对全部字段进行更新
     *
     * @param t
     * @return
     */
    public void update(T t);

    public void delete(T t);

    public void save(T t);

}
