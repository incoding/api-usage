package com.javaapi.test.appframework.shard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by user on 17/5/4.
 * http://www.cnblogs.com/DengGao/p/6387708.html
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




}
