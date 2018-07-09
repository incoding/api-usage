package com.javaapi.test.dao.baseDao.ClientHibernate;

import com.javaapi.test.dao.baseDao.domain.User;
import com.javaapi.test.dao.baseDao.page.PageOneRequest;
import com.javaapi.test.dao.baseDao.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Transactional
public class Client {

    @Autowired
    private UserService userService;

    @Test
    public void testFindById() {
        User one = userService.findOne(5);
        System.out.println(one);
    }

    @Test
    public void testFindAll() {
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        List<User> all = userService.findAll(ids);
        System.out.println("all = " + all);
    }

    @Test
    @Rollback(value = false)
    public void testSave() {
        User one = userService.findOne(5);
        User target = new User();
        BeanUtils.copyProperties(one, target);
        Integer newId = userService.save(target);
        System.out.println("newId = " + newId);
        Assert.assertEquals(true, newId instanceof Integer);
    }

    @Test
    @Rollback(value = false)
    public void testSaveList() {
        User one = userService.findOne(5);
        User target = new User();
        User target2 = new User();

        BeanUtils.copyProperties(one, target);

        BeanUtils.copyProperties(one, target2);

        User[] users = {target, target2};

        ArrayList<User> users1 = new ArrayList<>();
        users1.add(target);
        users1.add(target2);
        users1.add(target);
        users1.add(target);
        users1.add(target);
        users1.add(target);

        int success = userService.save(users1);
        System.out.println("success = >" + success);
    }

    /**
     * 如果出现多个,会报异常
     * @throws Exception
     */
    @Test
    public void testFindOneHql() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("password", "nihao");
        User one = userService.findOne("FROM User user WHERE user.password=:password", params);
        System.out.println("one = " + one);
    }

    @Test
    public void testFindAllHql() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("password", "nihao");
        List<User> all = userService.findAll("FROM User user WHERE user.password=:password", params);
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindAllPage() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("password", "nihao");
        int page = 0;
        int size = 2;
        PageRequest pageable = new PageRequest(page, size);
        Page<User> all = userService.findAll("FROM User user WHERE user.password=:password", pageable, params);
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
    @Test
    public void testFindAllPageByPageOneRequest_1() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("password", "nihao");
        int page = 1;
        int size = 6;
        PageOneRequest pageable = new PageOneRequest(page, size);
        Page<User> all = userService.findAll("FROM User user WHERE user.password=:password", pageable, params);
        List<User> content = all.getContent();
        // list
        System.out.println("content = " + content);
        // pageNo
        System.out.println("all.getNumber() = " + all.getNumber());
//        Assert.assertEquals(page, all.getNumber());
        // pageSize
        System.out.println("size = " + all.getSize());
//        Assert.assertEquals(size, all.getSize());
        // 具体数据的数量
        System.out.println("all.getNumberOfElements() = " + all.getNumberOfElements());
        // 总页数
        System.out.println("all.getTotalPages() = " + all.getTotalPages());
        // 总条数
        System.out.println("all.getTotalElements = " + all.getTotalElements());

        // 有前一个么
        System.out.println("all.hasPrevious() = " + all.hasPrevious());
        // 有下一个么
        System.out.println("all.hasNext() = " + all.hasNext());
        // 是第一个么
        System.out.println("all.isFirst() = " + all.isFirst());
        // 是最后一个么
        System.out.println("all.isLast() = " + all.isLast());

        // 该页具体的list数据长度
        System.out.println("all.nextPageable() = " + all.nextPageable());
        System.out.println("all.previousPageable() = " + all.previousPageable());
        System.out.println("all.hasContent() = " + all.hasContent());

    }


    @Test
     public void testFindAllPageByPageOneRequest_2() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("password", "nihao");
        int page = 2;
        int size = 6;
        PageOneRequest pageable = new PageOneRequest(page, size);
        Page<User> all = userService.findAll("FROM User user WHERE user.password=:password", pageable, params);
        List<User> content = all.getContent();
        // list
        System.out.println("content = " + content);
        // pageNo
        System.out.println("all.getNumber() = " + all.getNumber());
//        Assert.assertEquals(page, all.getNumber());
        // pageSize
        System.out.println("size = " + all.getSize());
//        Assert.assertEquals(size, all.getSize());
        // 具体数据的数量
        System.out.println("all.getNumberOfElements() = " + all.getNumberOfElements());
        // 总页数
        System.out.println("all.getTotalPages() = " + all.getTotalPages());
        // 总条数
        System.out.println("all.getTotalElements = " + all.getTotalElements());

        // 有前一个么
        System.out.println("all.hasPrevious() = " + all.hasPrevious());
        // 有下一个么
        System.out.println("all.hasNext() = " + all.hasNext());
        // 是第一个么
        System.out.println("all.isFirst() = " + all.isFirst());
        // 是最后一个么
        System.out.println("all.isLast() = " + all.isLast());

        // 该页具体的list数据长度
        System.out.println("all.nextPageable() = " + all.nextPageable());
        System.out.println("all.previousPageable() = " + all.previousPageable());
        System.out.println("all.hasContent() = " + all.hasContent());
    }

    @Test
    public void testFindAllPageByPageOneRequest_3() throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("password", "nihao");
        int page = 3;
        int size = 6;
        PageOneRequest pageable = new PageOneRequest(page, size);
        Page<User> all = userService.findAll("FROM User user WHERE user.password=:password", pageable, params);
        List<User> content = all.getContent();
        // list
        System.out.println("content = " + content);
        // pageNo
        System.out.println("all.getNumber() = " + all.getNumber());
//        Assert.assertEquals(page, all.getNumber());
        // pageSize
        System.out.println("size = " + all.getSize());
//        Assert.assertEquals(size, all.getSize());
        // 具体数据的数量
        System.out.println("all.getNumberOfElements() = " + all.getNumberOfElements());
        // 总页数
        System.out.println("all.getTotalPages() = " + all.getTotalPages());
        // 总条数
        System.out.println("all.getTotalElements = " + all.getTotalElements());

        // 有前一个么
        System.out.println("all.hasPrevious() = " + all.hasPrevious());
        // 有下一个么
        System.out.println("all.hasNext() = " + all.hasNext());
        // 是第一个么
        System.out.println("all.isFirst() = " + all.isFirst());
        // 是最后一个么
        System.out.println("all.isLast() = " + all.isLast());

        // 该页具体的list数据长度
        System.out.println("all.nextPageable() = " + all.nextPageable());
        System.out.println("all.previousPageable() = " + all.previousPageable());
        System.out.println("all.hasContent() = " + all.hasContent());
    }

    @Test
    public void testFindAllByExample() throws Exception {
        User user = new User();
        user.setPassword("nihao");
        int page = 2;
        int size = 7;
        Page<User> all = userService.findAll(user, page, size);
        List<User> content = all.getContent();
        // list
        System.out.println("content = " + content);
        // pageNo
        System.out.println("all.getNumber() = " + all.getNumber());
//        Assert.assertEquals(page, all.getNumber());
        // pageSize
        System.out.println("size = " + all.getSize());
//        Assert.assertEquals(size, all.getSize());
        // 具体数据的数量
        System.out.println("all.getNumberOfElements() = " + all.getNumberOfElements());
        // 总页数
        System.out.println("all.getTotalPages() = " + all.getTotalPages());
        // 总条数
        System.out.println("all.getTotalElements = " + all.getTotalElements());

        // 有前一个么
        System.out.println("all.hasPrevious() = " + all.hasPrevious());
        // 有下一个么
        System.out.println("all.hasNext() = " + all.hasNext());
        // 是第一个么
        System.out.println("all.isFirst() = " + all.isFirst());
        // 是最后一个么
        System.out.println("all.isLast() = " + all.isLast());

        // 该页具体的list数据长度
        System.out.println("all.nextPageable() = " + all.nextPageable());
        System.out.println("all.previousPageable() = " + all.previousPageable());
        System.out.println("all.hasContent() = " + all.hasContent());
    }
}
