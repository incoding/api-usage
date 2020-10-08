package com.javaapi.test.buisness.boilerplate.dbscan;


import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by user on 2020/10/7.
 */
public class DbScanTemplateNative {

    public <T> void dbScan(BiFunction<Long, Integer, List<T>> biFunction, Function<T, Long> getIdFunction, BiConsumer<Integer, List<T>> handleData) {
        Long id = 0L;
        Integer pageSize = 5000;
        //TODO
        System.out.println("start");
        int pageIndex = 0;
        while (true) {
            List<T> result = biFunction.apply(id, pageSize);
            if (result == null || result.isEmpty()) {
                break;
            }
            pageIndex += 1;
            handleData.accept(pageIndex, result);
            id = getIdFunction.apply(result.get(result.size() - 1));
        }
        //TODO
        System.out.println("done");
    }


}
