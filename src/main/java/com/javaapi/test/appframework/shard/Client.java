package com.javaapi.test.appframework.shard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by user on 17/5/4.
 */
public class Client {
    @Test
    public void test(){
        List<String> serverList = new ArrayList<>();
        serverList.add("127.0.0.1");
        serverList.add("127.0.0.2");
        serverList.add("127.0.0.3");
        serverList.add("127.0.0.4");
        serverList.add("127.0.0.5");
        Shard<String> shard = new Shard<>(serverList);


        List<String> keys = new ArrayList<>();
        keys.add("nihao");
        keys.add("nihao2");
        keys.add("nihao3");
        keys.add("nihao4");
        keys.add("nihao5");
        for (String key : keys) {
            String shardInfo = shard.getShardInfo(key);
            System.out.println("key="+key+",shard="+shardInfo);
        }
    }

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


        if (longStringSortedMap .size() == 0){
            return treeMap.get(treeMap.firstKey());
        }
        return longStringSortedMap.get(longStringSortedMap.firstKey());
    }
}
