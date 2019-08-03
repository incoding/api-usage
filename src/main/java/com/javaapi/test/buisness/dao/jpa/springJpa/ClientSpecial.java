package com.javaapi.test.buisness.dao.jpa.springJpa;

import com.javaapi.test.buisness.dao.jpa.springJpa.dao.UserDaoSpecification;
import com.javaapi.test.buisness.dao.jpa.springJpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *  可以实现单表动态查询,但是比较麻烦
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@ActiveProfiles("development")
//@Transactional
public class ClientSpecial {


    @Autowired
    private UserDaoSpecification userDaoSpecification;

    @Test
    public void testFindOne() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {
        List<User> all = userDaoSpecification.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                System.out.println("do job");
                return null;
            }
        });
        System.out.println(all);
    }
}