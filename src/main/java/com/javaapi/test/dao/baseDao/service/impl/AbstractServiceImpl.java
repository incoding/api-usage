/**
 * 文件名：@AbstractServiceImpl.java <br/>
 */
package com.javaapi.test.dao.baseDao.service.impl;

import com.javaapi.test.dao.baseDao.impl.hibernateImpl.HibernateBaseDaoImpl;
import com.javaapi.test.dao.baseDao.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public abstract class AbstractServiceImpl<E,ID extends Serializable, P extends HibernateBaseDaoImpl<E,ID>> implements BaseService<E> {
	
	// 数据访问对象
	@Autowired
	protected P persist;

	@Override
	public E find(Integer id) {
		return persist.findById((ID)id);
	}


	@Override
	public List<E> find(Collection<Integer> ids) {
        return  null;
	}


	@Override
	public List<E> find(E entity) {
        return  null;
	}


	@Override
	public E findFirst(E entity) {
		List<E> list = find(entity);

		// 取得集合的第一个元素
		return null == list || list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<E> find(E entity, Long start, Integer offset) {
        return  null;
	}


	@Override
	public Long findTotalSize(E entity) {
        return  null;
	}


	@Override
	public Integer delete(Integer[] ids) {
        return  null;

    }


	@Override
	public E add(E entity) {
        return  null;
	}


	@Override
	public E edit(E entity) {
        return  null;
	}
}
