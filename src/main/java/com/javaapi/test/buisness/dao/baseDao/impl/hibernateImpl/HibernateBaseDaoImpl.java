package com.javaapi.test.buisness.dao.baseDao.impl.hibernateImpl;

import com.javaapi.test.buisness.dao.baseDao.base.IBaseHqlDao;
import com.javaapi.test.buisness.dao.baseDao.page.PageOneImpl;
import org.hibernate.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 16/8/2.
 */
public class HibernateBaseDaoImpl<T, ID extends Serializable> extends BaseDaoImpl<T, ID> implements IBaseHqlDao<T, ID> {


    /**
     * 传入一个已经持久化的实体,所以一般情况下都会执行成功
     * 执行不成功会抛出异常
     *
     * @param t
     */
    @Override
    public void update(T t) {
        getSession().update(t);
    }

    /**
     * 传入一个已经持久化的实体,所以一般情况下都会执行成功
     * 执行不成功会抛出异常
     *
     * @param t
     */
    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    /**
     * 传入一个已经持久化的实体,所以一般情况下都会执行成功
     * 执行不成功会抛出异常
     *
     * @param t
     */
    @Override
    public void save(T t) {
        getSession().save(t);
    }


    @Override
    public T findOne(String hql, Map params) {
        Finder finder = Finder.create(hql);
        finder.setParams(params);

        Query query = getSession().createQuery(finder.getOrigHql());
        finder.setParamsToQuery(query);
        if (finder.isCacheable()) {
            query.setCacheable(true);
        }
        T o = (T) query.uniqueResult();
        return o;
    }
    @Override
    public Page<T> findAll(String hql, Pageable pageable, Map params) {
        Finder finder = Finder.create(hql);
        finder.setParams(params);
        int total = countQueryResult(finder);
        if (total < 1) {
            PageOneImpl<T> page = new PageOneImpl<>(new ArrayList(), pageable, total);
            return page;
        }


        Query query = getSession().createQuery(finder.getOrigHql());
        finder.setParamsToQuery(query);
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        if (finder.isCacheable()) {
            query.setCacheable(true);
        }


        Iterator<T> iterate = query.iterate();
        List<T> list = new ArrayList();
        while(iterate.hasNext()){
            T o = iterate.next();
            list.add(o);
        }
        PageOneImpl<T> page = new PageOneImpl<>(list, pageable, total);
        return page;
    }

    @Override
    public List<T> findAll(String hql, Map params) {
        Finder finder = Finder.create(hql);
        finder.setParams(params);
        Query query = getSession().createQuery(finder.getOrigHql());
        finder.setParamsToQuery(query);
        if (finder.isCacheable()) {
            query.setCacheable(true);
        }

        Iterator<T> iterate = query.iterate();
        List<T> list = new ArrayList();
        while(iterate.hasNext()){
            T o = iterate.next();
            list.add(o);
        }
        return list;
    }

//    @Override
//    public T findOne(String hql, List params) {
//        return null;
//    }
//
//    @Override
//    public T findOne(String hql, Object... params) {
//        return null;
//    }
//
//    @Override
//    public List<T> findAll(String hql, List params) {
//        return null;
//    }
//
//    @Override
//    public List<T> findAll(String hql, Object... params) {
//        return null;
//    }
//
//    @Override
//    public Page<T> findAll(String hql, Pageable pageable, List params) {
//        return null;
//    }
//
//
//    @Override
//    public Page<T> findAll(String hql, Pageable pageable, Object... params) {
//        return null;
//    }


}
