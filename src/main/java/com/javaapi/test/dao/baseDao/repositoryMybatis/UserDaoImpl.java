package com.javaapi.test.dao.baseDao.repositoryMybatis;

import com.javaapi.test.dao.baseDao.domain.User;
import com.javaapi.test.dao.baseDao.impl.mybatisImpl.MybatisBaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 16/8/3.
 */
@Repository
public class UserDaoImpl extends MybatisBaseDao<User,Integer> implements UserDao {

}
