/**
 * 文件名：@BaseService.java <br/>
 */
package com.javaapi.test.dao.baseDao.service;

import java.util.Collection;
import java.util.List;


public interface BaseService<E> {

	E find(Integer id);
	

	List<E> find(Collection<Integer> ids);
	

	List<E> find(E entity);
	

	E findFirst(E entity);


	List<E> find(E entity, Long start, Integer offset);
	

	Long findTotalSize(E entity);
	

	E add(E entity);
	

	E edit(E entity);
	

	Integer delete(Integer[] ids) throws Exception;
}
