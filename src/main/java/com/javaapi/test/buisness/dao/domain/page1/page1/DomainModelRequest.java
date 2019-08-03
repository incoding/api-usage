package com.javaapi.test.buisness.dao.domain.page1.page1;

/**
 * Created by user on 2018/8/18
 */
public class DomainModelRequest extends DomainModelQuery {

    public void setPageSize(int pageSize) {
        if (getPagination() == null) {
            setPagination(new Pagination());
        }
        getPagination().setPageSize(pageSize);
    }

    public void setPageNo(int pageNo) {
        if (getPagination() == null) {
            setPagination(new Pagination());
        }
        getPagination().setPageNo(pageNo);
    }

}
