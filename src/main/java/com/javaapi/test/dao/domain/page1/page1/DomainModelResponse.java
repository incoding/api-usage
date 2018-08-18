package com.javaapi.test.dao.domain.page1.page1;

/**
 * Created by user on 2018/8/18
 */
public class DomainModelResponse extends DomainModel {

    public Pagination<DomainModel> pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DomainModelResponse{");
        sb.append("pagination=").append(pagination);
        sb.append('}');
        return sb.toString();
    }
}
