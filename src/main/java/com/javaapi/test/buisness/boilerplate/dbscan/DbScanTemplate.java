package com.javaapi.test.buisness.boilerplate.dbscan;


import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Created by user on 2020/10/7.
 */
@Slf4j
public class DbScanTemplate<T, U> {

    private Function<U, List<T>> dbQueryListFunction;
    private BiConsumer<Integer, List<T>> handleMethod;
    private Function<T, Long> getId;
    private BiConsumer<U, Long> setId;


    public DbScanTemplate() {
    }


    DbScanTemplate(Function<U, List<T>> dbQueryListFunction, BiConsumer<Integer, List<T>> handleMethod, Function<T, Long> getId, BiConsumer<U, Long> setId) {
        this.dbQueryListFunction = dbQueryListFunction;
        this.handleMethod = handleMethod;
        this.getId = getId;
        this.setId = setId;
    }

    public void dbScanByParam(U dbQuery) {
        //TODO
        log.info("start");
        int pageIndex = 0;
        while (true) {
            List<T> result = this.dbQueryListFunction.apply(dbQuery);
            if (result == null || result.isEmpty()) {
                break;
            }
            pageIndex += 1;
            this.handleMethod.accept(pageIndex, result);
            int lastItem = result.size() - 1;
            // 设置为最新id,用于下次滚动
            this.setId.accept(dbQuery, this.getId.apply(result.get(lastItem)));
        }
        //TODO
        log.info("done");
    }

}
