package com.javaapi.test.buisness.boilerplate.dbscan;


import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * Created by user on 2020/10/7.
 */
public class DbScanTemplatePage<T, U> {

    private Function<U, List<T>> dbQueryListFunction;
    private BiConsumer<Integer, List<T>> handleMethod;
    private Function<U, Integer> getPageNoFunc;
    private BiConsumer<U, Integer> setPageNoFunc;


    public DbScanTemplatePage() {
    }


    DbScanTemplatePage(Function<U, List<T>> dbQueryListFunction, BiConsumer<Integer, List<T>> handleMethod, Function<U, Integer> getPageNoFunc, BiConsumer<U, Integer> setPageNoFunc) {
        this.dbQueryListFunction = dbQueryListFunction;
        this.handleMethod = handleMethod;
        this.getPageNoFunc = getPageNoFunc;
        this.setPageNoFunc = setPageNoFunc;
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
            this.setPageNoFunc.accept(dbQuery, this.getPageNoFunc.apply(dbQuery) + 1);
        }
        //TODO
        System.out.println("done");
    }

}
