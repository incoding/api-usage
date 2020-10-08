package com.javaapi.test.buisness.boilerplate.dbscan;


import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Created by user on 2020/10/7.
 */
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
        System.out.println("start");
        int pageAlready = 0;
        while (true) {
            List<T> result = this.dbQueryListFunction.apply(dbQuery);
            if (result == null || result.isEmpty()) {
                break;
            }
            pageAlready += 1;
            this.handleMethod.accept(pageAlready, result);
            this.setId.accept(dbQuery, this.getId.apply(result.get(result.size() - 1)));
        }
        //TODO
        System.out.println("done");
    }

}
