package com.javaapi.test.buisness.dao.jpa.springJpa;

import com.javaapi.test.buisness.dao.jpa.springJpa.dao.UserDaoQBE;
import com.javaapi.test.buisness.dao.jpa.springJpa.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 1  可以实现单表动态查询
 * 2  更复杂的查询需要再探索下example
 * 3 另外 spring data jpa 新版本中,自己的接口只要继承JpaRepository,自带qbe功能了
 * 4 看queryDsl的实现类的diagram就能看到jpa的所有查询
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@ActiveProfiles("development")
//@Transactional
public class ClientQBE {


    @Autowired
    private UserDaoQBE userDaoQBE;

    @Test
    public void testFindOne() throws Exception {
        User user = new User();
        user.setPassword("nihaoppp");
        User one = userDaoQBE.findOne(Example.of(user));
        System.out.println("one = " + one);
    }

    @Test
    public void testFindAll() throws Exception {
        User user = new User();
        user.setPassword("nihao");
        List<User> all = userDaoQBE.findAll(Example.of(user));
        all.stream().forEach((s) -> {
            System.out.println(s);
        });
    }

    /**
     * 按分页查询
     * @throws Exception
     */
    @Test
    public void testFindAllByPage() throws Exception {
        User user = new User();
        user.setPassword("nihao");
        Example<User> example = Example.of(user);
        int page = 0;
        int size = 1;
        PageRequest pageable = new PageRequest(page, size, Sort.Direction.ASC,"id");
        Page<User> all = userDaoQBE.findAll(example, pageable);
        List<User> content = all.getContent();
        // list
        System.out.println("content = " + content);
        // pageNo
        System.out.println("pageNo = " + all.getNumber());
        Assert.assertEquals(page, all.getNumber());
        // pageSize
        System.out.println("size = " + all.getSize());
        Assert.assertEquals(size, all.getSize());
        // 总页数
        System.out.println("all.getTotalPages() = " + all.getTotalPages());
        // 总条数
        System.out.println("all.getTotalElements = " + all.getTotalElements());
    }

}