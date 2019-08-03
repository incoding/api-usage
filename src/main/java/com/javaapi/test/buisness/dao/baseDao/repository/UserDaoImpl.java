package com.javaapi.test.buisness.dao.baseDao.repository;

import com.javaapi.test.buisness.dao.baseDao.domain.User;
import com.javaapi.test.buisness.dao.baseDao.impl.hibernateImpl.HibernateBaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 16/8/3.
 */
@Repository
public class UserDaoImpl extends HibernateBaseDaoImpl<User,Integer> implements UserDao {
}
