package com.javaapi.test.appframework.shard;

import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by user on 2018/11/3
 */
public class VerifyClient {
    /**
     * tailMap 方法返回大于给定key的  数据
     * 用于构造环状数据
     */
    @Test
    public void testTreeMap(){
        TreeMap<Long, String> treeMap = new TreeMap<>();
        treeMap.put((long) 1, "nihao1");
        treeMap.put((long) 100, "nihao100");
        treeMap.put((long) 1000, "nihao1000");
        treeMap.put((long) 10000, "nihao10000");

        Long[] longs = {0L, 2L, 103L, 10004L};
        for (Long tmp: longs) {
            SortedMap<Long, String> longStringSortedMap = treeMap.tailMap(tmp);
        }
    }

    /**
     * 利用treemap的tailMap方法构造环状数据
     */
    @Test
    public void testTreeMap2(){
        TreeMap<Long, String> treeMap = new TreeMap<>();
        treeMap.put((long) 1, "nihao1");
        treeMap.put((long) 100, "nihao100");
        treeMap.put((long) 1000, "nihao1000");
        treeMap.put((long) 10000, "nihao10000");

        Long[] longs = {0L, 2L, 103L, 10004L};
        for (Long tmp: longs) {
            String value = getKey(treeMap, tmp);
            System.out.println("给定的key为"+tmp+",得到的值为 value = " + value);
        }
    }

    private String getKey(TreeMap<Long, String> treeMap, Long tmp) {
        SortedMap<Long, String> longStringSortedMap = treeMap.tailMap(tmp);


        if (longStringSortedMap.size() == 0){
            return treeMap.get(treeMap.firstKey());
        }
        return longStringSortedMap.get(longStringSortedMap.firstKey());
    }
}
