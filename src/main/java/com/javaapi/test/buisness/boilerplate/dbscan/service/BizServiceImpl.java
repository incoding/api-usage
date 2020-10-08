package com.javaapi.test.buisness.boilerplate.dbscan.service;

import com.javaapi.test.buisness.boilerplate.dbscan.dao.DbDomain;

import java.util.List;

/**
 * Created by user on 2020/10/7.
 */
public class BizServiceImpl implements BizService {


    @Override
    public void doSomeThing(int pageIndex, List<DbDomain> result) {
        System.out.println("do page = " + pageIndex);
    }

}
