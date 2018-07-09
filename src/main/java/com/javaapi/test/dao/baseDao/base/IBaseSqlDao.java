package com.javaapi.test.dao.baseDao.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 16/8/2.
 */
public interface IBaseSqlDao<T,ID extends Serializable> extends IBaseDao<T,ID> {

    public T findByIdInteger(Integer id);

    /**
     * ----sql start -----------------------------------------
     */

    /**
     * 按sql 查询 单个实体
     * @param
     * @param params
     * @return
     */
    public T selectOne(String sql, Map<String, Object> params);

    public T selectOne(String sql, Object... params);

    public T selectOne(String sql, List<Object> params);

    /**
     * 按sql进行查询 实体list
     * @param sql
     * @param params
     * @return
     */
    public List<T> selectAll(String sql, Map<String, Object> params);

    public Page<T> selectAll(String sql, Pageable pageable, Map<String, Object> params);

    /**
     * 按sql进行查询 实体list
     * @param sql
     * @param params
     * @return
     */
    public List<T> selectAll(String sql, Object... params);

    public Page<T> selectAll(String sql, Pageable pageable, Object... params);


    /**
     * 按sql进行查询 实体list
     * @param sql
     * @param params
     * @return
     */
    public List<T> selectAll(String sql, List<Object> params);

    public Page<T> selectAll(String sql, Pageable pageable, List<Object> params);

    /**
     * -----sql end----------------------------------------
     */

}
