package com.javaapi.test.buisness.boilerplate.dbscan.dao;

import com.alibaba.fastjson.JSON;
import org.testng.collections.Lists;

import java.util.List;

/**
 * Created by user on 2020/10/7.
 */
public class DbDaoImpl implements DbDao {

    @Override
    public List<DbDomain> queryDb(DbPageQuery dbQuery) {
        if (dbQuery.getPageNo() >= 10) {
            return Lists.newArrayList();
        }
        System.out.println("dbQuery = " + JSON.toJSONString(dbQuery));
        List<DbDomain> dbDomains = Lists.newArrayList();
        DbDomain e = new DbDomain();
        e.setId(1l);
        dbDomains.add(e);
        return dbDomains;
    }


    @Override
    public List<DbDomain> queryDb(DbIdQuery dbQuery) {
        if (dbQuery.getId() == 10) {
            return Lists.newArrayList();
        }
        System.out.println("dbQuery = " + JSON.toJSONString(dbQuery));
        List<DbDomain> dbDomains = Lists.newArrayList();
        DbDomain e = new DbDomain();
        e.setId((dbQuery.getId() + 1));
        dbDomains.add(e);
        System.out.println("id = " + dbQuery.getId());
        return dbDomains;
    }

    @Override
    public List<DbDomain> queryDb(Long id, Integer pageSize) {
        if (id == 10) {
            return Lists.newArrayList();
        }
        List<DbDomain> dbDomains = Lists.newArrayList();
        DbDomain e = new DbDomain();
        e.setId((id + 1));
        dbDomains.add(e);
        System.out.println("id = " + id);
        return dbDomains;
    }
}
