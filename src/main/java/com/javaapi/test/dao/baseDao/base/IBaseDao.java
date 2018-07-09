package com.javaapi.test.dao.baseDao.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * 一个baseDao应该有的功能
 * 根据id 查询实体,返回单个实体
 * 根据id list进行查询,并返回实体list
 * 根据实体查询实体list,返回分页实体list,分页需要order by   //TODO ??
 * 可以自定义sql/hql,可连表                              TODO
 * <p>
 * <p>
 * <p>
 * <p>
 * 根据id进行删除,并返回删除个数
 * 根据id list进行删除,并返回删除个数
 * 根据实体条件进行删除,并返回删除个数  (可选)
 * <p>
 * 动态更新单个实体,传入单个实体 ,返回 void
 * 动态更新单个实体,传入单个实体,返回更新个数: 0/1  (可选)
 *
 * 对全部字段进行更新,传入单个实体,返回void
 * 对全部字段进行更新,传入单个实体,返回更新个数: 0/1 (可选)
 * <p>
 * 保存单个实体,返回值为void
 * 保存单个实体,返回插入条数 0/1 (可选)
 * 保存单个实体,返回新数据的主键值 (可选)
 * 保存实体list,返回插入条数
 * <p>
 * <p>
 * 判断实体是否存在,传入实体参数,返回 布尔值  (boolean)
 * 判断id对应的数据是否存在,传入id参数,返回 布尔值  (boolean)
 */
public interface IBaseDao<T, ID extends Serializable>{

    /**
     *   * 根据id 查询实体,返回单个实体

     * @param id
     * @return
     */
    public T findById(ID id);




    /**
     * 按id list进行查询实体,返回单个实体
     * @param id
     * @return
     */
    public List<T> findAll(List<ID> id);


    /**按实体进行分页查询
     * @param
     */
    public Page<T> findAll(T t, Integer pageNo, Integer pageSize);

    /**按实体进行分页查询
     * @param
     */
    public Page<T> findAll(T t, Pageable pageable);

    /**
     * 查询所有实体
     * @return
     */
    public List<T> findAll();

    /**
     * 按单个id进行删除
     *
     * @param id
     * @return
     */
    public int deleteById(ID id);

    /**
     * 按批量id进行删除
     *
     * @param ids
     * @return
     */
    public int deleteByIds(List<ID> ids);


    /**
     * 保存实体,返回新生成的id
     * @param t
     * @return
     */
    ID saveRID(T t);

    /**
     * 保存实体list,返回更新条数
     *
     * @param ts
     * @return
     */
    public int save(List<T> ts);

    /**
     * 按id,对非null值进行更新 (动态更新)
     *
     * @param t
     * @return
     */
    public int updateDynamic(T t);

    /**
     * 返回影响行数, 不会出异常  0/1
     *
     * @param t
     * @return
     */
    public int saveRRC(T t);

    /**
     * 返回影响行数, 不会出异常  0/1
     * Return Row Count
     * @param t
     * @return
     */
    public int deleteRRC(T t);

    /**
     * 返回更新行数, 不会出异常  0/1
     * Return Row Count
     * @param t
     * @return
     */
    public int updateRRC(T t);



}
