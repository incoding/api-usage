package com.javaapi.test.buisness.dao.domain.page1.page1;

/**
 * Created by user on 2018/8/18
 */
public class DomainModelQuery extends DomainModel {

    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DomainModelQuery{");
        sb.append("parent=").append(super.toString());
        sb.append("pagination=").append(pagination);
        sb.append('}');
        return sb.toString();
    }
}
