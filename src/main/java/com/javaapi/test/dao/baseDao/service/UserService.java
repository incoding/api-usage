package com.javaapi.test.dao.baseDao.service;

import com.javaapi.test.dao.baseDao.domain.User;
import com.javaapi.test.dao.baseDao.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;


    public User findOne(Integer id) {
        return  userDao.findById(id);
    }

    public List<User> findAll(List<Integer> id) {
        return userDao.findAll(id);
    }

    public int save(List<User> users) {
        return userDao.save(users);
    }

    public Integer save(User user) {
        userDao.save(user);
        return 1;
    }

    public User findOne(String hql, Map<String, Object> params) {
        return userDao.findOne(hql, params);
    }

    public User findById(Integer integer) {
        return userDao.findById(integer);
    }

    public int deleteById(Integer integer) {
        return userDao.deleteById(integer);
    }



    public int updateRRC(User user) {
        return userDao.updateRRC(user);
    }



    public int updateDynamic(User user) {
        return userDao.updateDynamic(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public int deleteRRC(User user) {
        return userDao.deleteRRC(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public int saveRRC(User user) {
        return userDao.saveRRC(user);
    }



    public List<User> findAll() {
        return userDao.findAll();
    }



    public int deleteByIds(List<Integer> integers) {
        return userDao.deleteByIds(integers);
    }

    public Page<User> findAll(String hql, Pageable pageable, Map<String, Object> params) {
        return userDao.findAll(hql, pageable, params);
    }

    public Page<User> findAll(User user, Pageable pageable) {
        return userDao.findAll(user, pageable);
    }

    public List<User> findAll(String hql, Map<String, Object> params) {
        return userDao.findAll(hql, params);
    }

    public Page<User> findAll(User user, Integer pageNo, Integer pageSize) {
        return userDao.findAll(user, pageNo, pageSize);
    }

    public Integer saveRID(User user) {
        return userDao.saveRID(user);
    }
}
