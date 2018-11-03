package com.javaapi.test.util.opensource.reactive.rxjava.concurrent;

import com.google.common.base.Joiner;
import org.junit.Test;
import org.testng.collections.Lists;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ClientConcurrent {
    /**
     * 循环的每个操作放到一个后台线程中
     * https://juejin.im/post/58ff6259da2f60005dd81459
     *
     * 阻塞,等待所以后线程处理完毕后输出
     */
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        List<String> dataList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            dataList.add(String.valueOf(i));
        }

//这里是数据列表

        List<Observable<DataModel>> tasks = new ArrayList<>();

        for (String data : dataList) {
            tasks.add(Observable.just(data).subscribeOn(Schedulers.io()).map(s -> {
                // 返回一个 DataModel 对象
                return DataParser.createData(s);
            }));
        }

        List<DataModel> result = new ArrayList<>();

// 等待运行结束并收集结果
        for (DataModel dataModel : Observable.merge(tasks).toBlocking().toIterable()) {
            result.add(dataModel);
        }
        System.out.println("result = " + result);
        System.out.println("done cost ="+(System.currentTimeMillis()-start));
    }

    private static class DataModel {
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public DataModel(String data) {
            this.data = data;
        }

        public DataModel() {
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("DataModel{");
            sb.append("data=").append(data);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class DataParser {
        public static DataModel createData(String s) {
            Random random = new Random();

            int timeout = random.nextInt(3);
            if ("20".equals(s)) {
                timeout = 20;
            }

            try {
                TimeUnit.SECONDS.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String join = Joiner.on("-").join(s, timeout,Thread.currentThread().getName());
            return new DataModel(join);
        }
    }
}
