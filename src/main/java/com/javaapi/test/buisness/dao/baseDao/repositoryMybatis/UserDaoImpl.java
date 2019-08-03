package com.javaapi.test.buisness.dao.baseDao.repositoryMybatis;

import com.javaapi.test.buisness.dao.baseDao.domain.User;
import com.javaapi.test.buisness.dao.baseDao.impl.mybatisImpl.MybatisBaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 16/8/3.
 */
@Repository
public class UserDaoImpl extends MybatisBaseDao<User,Integer> implements UserDao {

}
