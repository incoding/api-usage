package com.javaapi.test.dao.domain.page1.page1;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
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
        //from dao
        int totalCount  = 100;

        Pagination<String> partData = getPartData(new Pagination(0, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println("list = " + list);
    }

    @Test
    public void testPageNo1() {
        // select count(1) from xxx;
        //from dao
        int totalCount  = 100;

        Pagination<String> partData = getPartData(new Pagination(1, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println("list = " + list);
    }

    @Test
    public void testPageNo2() {
        // select count(1) from xxx;
        //from dao
        int totalCount  = 100;

        Pagination<String> partData = getPartData(new Pagination(2, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println(list);

    }
    @Test
    public void testPageNo3() {
        // select count(1) from xxx;
        //from dao
        int totalCount  = 100;

        Pagination<String> partData = getPartData(new Pagination(2, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println(list);

    }

    @Test
    public void testPageNoLast() {
        // select count(1) from xxx;
        //from dao
        int totalCount  = 100;

        Pagination<String> partData = getPartData(new Pagination(10, 10, totalCount));
        List<String> list = partData.getList();
        System.out.println(list);
    }

    @Test
    public void testHelloWorld() throws Exception {

        String param = "{\"name\":\"xxx\",\"pageNo\":1,\"pageSize\":10}";
        DomainModelRequest domainModelRequest = JSON.parseObject(param, DomainModelRequest.class);
        System.out.println("domainModelRequest = " + domainModelRequest);
        DomainModelResponse domainModelResponse = controllerMethod(domainModelRequest);
        System.out.println("domainModelResponse = " + domainModelResponse);
    }

    private DomainModelResponse controllerMethod(DomainModelRequest domainModelRequest) {
        Pagination pagination = serviceMethod(domainModelRequest);
        DomainModelResponse domainModelResponse = new DomainModelResponse();
        domainModelResponse.setPagination(pagination);
        return domainModelResponse;
    }

    private Pagination serviceMethod(DomainModelQuery domainModelQuery) {

        Pagination pagination = domainModelQuery.getPagination();
        int count = daoCountMethod(domainModelQuery);
        if (count == 0) {
            pagination.setTotalCount(count);
            return pagination;
        }
        pagination.setTotalCount(count);
        List<DomainModel> domainModels = daoListMethod(domainModelQuery);
        pagination.setList(domainModels);
        return pagination;
    }


    private int daoCountMethod(DomainModelQuery domainModelQuery) {
        return 100;
    }

    private List<DomainModel> daoListMethod(DomainModelQuery domainModelQuery) {
        return Lists.newArrayList(new DomainModel());
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

