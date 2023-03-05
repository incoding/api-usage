package com.javaapi.test.buisness.boilerplate.dbscan;

import com.javaapi.test.buisness.boilerplate.dbscan.dao.*;
import com.javaapi.test.buisness.boilerplate.dbscan.service.BizService;
import com.javaapi.test.buisness.boilerplate.dbscan.service.BizServiceImpl;
import org.junit.Test;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by user on 2020/10/7.
 */
public class Client {

    private DbDao dbDao = new DbDaoImpl();
    private BizService bizService = new BizServiceImpl();

    @Test
    public void test() {
        BiFunction<Long, Integer, List<DbDomain>> queryDb = (id, pageSize) -> dbDao.queryDb(id, pageSize);
        Function<DbDomain, Long> getId = DbDomain::getId;
        BiConsumer<Integer, List<DbDomain>> handleMethod = (pageIndex, result) -> bizService.doSomeThing(pageIndex, result);
        new DbScanTemplateNative().dbScan(queryDb, getId, handleMethod);
    }

    /**
     * 按id滚动查询
     */
    @Test
    public void testParam() {
        Function<DbIdQuery, List<DbDomain>> dbQueryListFunction = dbDao::queryDb;
        Function<DbDomain, Long> getId = DbDomain::getId;
        BiConsumer<DbIdQuery, Long> setId = DbIdQuery::setId;
        BiConsumer<Integer, List<DbDomain>> handleMethod = (pageIndex, result) -> bizService.doSomeThing(pageIndex, result);
        DbIdQuery dbQuery = new DbIdQuery();
        dbQuery.setId(0l);
        dbQuery.setPageSize(5000);
        new DbScanTemplate(dbQueryListFunction, handleMethod, getId, setId).dbScanByParam(dbQuery);
    }

    /**
     * 分页查询
     */
    @Test
    public void testParam2() {
        Function<DbPageQuery, List<DbDomain>> dbQueryListFunction = dbDao::queryDb;
        Function<DbPageQuery, Integer> getPageNo = DbPageQuery::getPageNo;
        BiConsumer<DbPageQuery, Integer> setPageNo = DbPageQuery::setPageNo;
        BiConsumer<Integer, List<DbDomain>> handleMethod = (pageIndex, result) -> bizService.doSomeThing(pageIndex, result);
        DbPageQuery dbQuery = new DbPageQuery();
        dbQuery.setPageNo(1);
        dbQuery.setPageSize(5000);
        new DbScanTemplatePage(dbQueryListFunction, handleMethod, getPageNo, setPageNo).dbScanByParam(dbQuery);
    }


}
