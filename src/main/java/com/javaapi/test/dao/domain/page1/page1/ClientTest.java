package com.javaapi.test.dao.domain.page1.page1;

import com.javaapi.test.dao.domain.page1.page1.Pagination;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 16/3/18.
 */
public class ClientTest {
    @Test
    public void testPageNo0() {
        // select count(1) from xxx;
        int totalCount  = 100;  //from dao

        Pagination<String> partData = getPartData(new Pagination(0, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println("list = " + list);
    }

    @Test
    public void testPageNo1() {
        // select count(1) from xxx;
        int totalCount  = 100;  //from dao

        Pagination<String> partData = getPartData(new Pagination(1, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println("list = " + list);
    }

    @Test
    public void testPageNo2() {
        // select count(1) from xxx;
        int totalCount  = 100;  //from dao

        Pagination<String> partData = getPartData(new Pagination(2, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println(list);

    }
    @Test
    public void testPageNo3() {
        // select count(1) from xxx;
        int totalCount  = 100;  //from dao

        Pagination<String> partData = getPartData(new Pagination(2, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println(list);

    }


    private <T> Pagination<T> getPartData(Pagination pagination) {
        int firstResult = pagination.getFirstResult();
        System.out.println("first = " + firstResult);
        int totalPage = pagination.getTotalPage();
        int pageSize = pagination.getPageSize();
        System.out.println("pageSize = "+pageSize);
        System.out.println("totalPage = "+totalPage);


        System.out.println("tcOrderInfoPagination = " + pagination);
        System.out.println("getList = " + pagination.getList());
        System.out.println("getTotalCount = " + pagination.getTotalCount());
        System.out.println("getPageSize = " + pagination.getPageSize());
        System.out.println("getPageNo = " + pagination.getPageNo());
        System.out.println("getFirstResult = " + pagination.getFirstResult());
        System.out.println("getNextPage = " + pagination.getNextPage());
        System.out.println("getPrePage = " + pagination.getPrePage());
        System.out.println("getTotalPage = " + pagination.getTotalPage());
        //sql  select * from xxx  order by yyy limit firstResult, pageSize;
        ArrayList<String> list = new ArrayList<>();
        list.add("nihao");
        list.add("nihao2");
        pagination.setList(list);
        return pagination;
    }
}

