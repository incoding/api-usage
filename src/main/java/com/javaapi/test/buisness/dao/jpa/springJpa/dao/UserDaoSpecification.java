package com.javaapi.test.buisness.dao.jpa.springJpa.dao;

import com.javaapi.test.buisness.dao.jpa.springJpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface UserDaoSpecification extends JpaRepository<User, Integer> ,JpaSpecificationExecutor {
}
