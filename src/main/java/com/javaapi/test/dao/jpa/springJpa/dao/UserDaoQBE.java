package com.javaapi.test.dao.jpa.springJpa.dao;

import com.javaapi.test.dao.jpa.springJpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface UserDaoQBE extends JpaRepository<User, Integer>{
    public User findByUsername(String username);

    @Query("select u from User u where u.username=:username")
    public User findUserByQueryAnnotation(@Param("username") String username);
}
