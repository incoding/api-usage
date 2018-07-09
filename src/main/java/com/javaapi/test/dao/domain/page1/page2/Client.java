package com.javaapi.test.dao.domain.page1.page2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/3/18.
 */
public class Client {

    @Test
    public void testPageNo() {
        // select count(1) from xxx;
        //from dao
        int totalCount  = getCount();
        Pager pager = new Pager(0, 10);
        pager.setTotalCount(totalCount);
        Pager<String> partData = getPartData(pager);
        List<String> list = partData.getList();
        System.out.println("list = " + list);
    }


    @Test
    public void testPageNo0() {
        // select count(1) from xxx;
        int totalCount  = getCount();  //from dao
        Pager pager = new Pager(0, 10);
        pager.setTotalCount(totalCount);
        Pager<String> partData = getPartData(pager);
        List<String> list = partData.getList();
        System.out.println("list = " + list);
    }

    @Test
    public void testPageNo1() {
        // select count(1) from xxx;
        int totalCount  = getCount();  //from dao
        Pager pager = new Pager(1, 10);
        pager.setTotalCount(totalCount);
        Pager<String> partData = getPartData(pager);
        List<String> list = partData.getList();
        System.out.println("list = " + list);
    }

    @Test
    public void testPageNo2() {
        // select count(1) from xxx;
        int totalCount  = getCount();  //from dao
        Pager pager = new Pager(2, 10);
        pager.setTotalCount(totalCount);
        Pager<String> partData = getPartData(pager);
        List<String> list = partData.getList();
        System.out.println(list);

    }
    @Test
    public void testPageNo3() {
        // select count(1) from xxx;
        int totalCount  = getCount();  //from dao
        Pager pager = new Pager(11, 10);
        pager.setTotalCount(totalCount);
        Pager<String> partData = getPartData(pager);
        List<String> list = partData.getList();
        System.out.println(list);

    }

    private int getCount() {
        return 100;
    }


    private <T> Pager<T> getPartData(Pager pager) {
        int firstResult = pager.getFirstResult();
        System.out.println("first = " + firstResult);
        int totalPage = pager.getTotalPage();
        int pageSize = pager.getPageSize();
        System.out.println("pageSize = "+pageSize);
        System.out.println("totalPage = "+totalPage);
        //sql  select * from xxx  order by yyy limit firstResult, pageSize;
        ArrayList<String> list = new ArrayList<>();
        list.add("nihao");
        list.add("nihao2");
        pager.setList(list);
        return pager;
    }
}

