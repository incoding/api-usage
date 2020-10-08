package com.javaapi.test.buisness.boilerplate.dbscan.dao;

import java.util.List;

/**
 * Created by user on 2020/10/7.
 */
public interface DbDao {
    List<DbDomain> queryDb(DbIdQuery dbQuery);

    List<DbDomain> queryDb(DbPageQuery dbQuery);

    List<DbDomain> queryDb(Long id, Integer pageSize);
}
