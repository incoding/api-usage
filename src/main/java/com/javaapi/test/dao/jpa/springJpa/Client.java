package com.javaapi.test.dao.jpa.springJpa;

import com.javaapi.test.dao.jpa.springJpa.dao.UserDao;
import com.javaapi.test.dao.jpa.springJpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by user on 16/1/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@ActiveProfiles("development")
//@Transactional
public class Client {
    @Autowired
    private UserDao userDao;


    @Test
    public void testInsert() throws Exception {
        User s = new User();
        s.setUsername("2nihao");
        s.setPassword("nihaoppp");
        User save = userDao.save(s);
        System.out.println("save = " + save);
    }

    // 保证有则,删除,需要先查询下,然后再删除.
    // 查询和接下来的删除在同一个事物中

    // 按id删除,即便是有一个delete方法,也是先查询下,有则删除,没有则不删除
    @Test
//    @Rollback(value = false)
    public void testDelete() throws Exception {
        //Hibernate: select user0_.id as id0_0_, user0_.password as password0_0_, user0_.username as username0_0_ from i_user user0_ where user0_.id=?
//        Hibernate: select user0_.id as id0_0_, user0_.password as password0_0_, user0_.username as username0_0_ from i_user user0_ where user0_.id=?
//        Hibernate: delete from i_user where id=?
        User one = userDao.findOne(4);
        userDao.delete(one);
    }

    @Test
    @Rollback(value = false)
    // 非显示更新
    public void testUpdate() throws Exception {
        User one = userDao.findOne(1);
        one.setUsername("kk4");
//        userDao.save(one);
        System.out.println("one = " + one);

    }

    @Test
    public void testExist() throws Exception {
        User one = userDao.findOne(1);
        System.out.println("userDao = " + userDao.exists(one.getId()));

    }


    @Test
    public void testCount() throws Exception {
        System.out.println("userDao = " + userDao.count());
    }

    @Test
    public void testPage() throws Exception {
        Page<User> all = userDao.findAll(new PageRequest(0, 1));
        System.out.println(all.getContent());
        System.out.println("all = " + all);
    }

    @Test
    public void testFindOne() throws Exception {
        User findOne = userDao.findOne(1);
        System.out.println(findOne);
        assertNotNull(findOne);
    }

    @Test
    public void findOne() throws Exception {
        User user = userDao.findUserByQueryAnnotation("admin");
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    public void testSelfImpl() throws Exception {
        User users = userDao.myFindAll("kk", "kkpassword");
        System.out.println("users = " + users);
    }

    @Test
    public void testName() throws Exception {

    }
}