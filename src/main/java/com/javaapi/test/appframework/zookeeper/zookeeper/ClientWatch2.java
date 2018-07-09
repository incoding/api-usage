package com.javaapi.test.appframework.zookeeper.zookeeper;

import org.apache.zookeeper.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 16/12/21.
 */
public class ClientWatch2 {
    @Test
    public void test() throws KeeperException, InterruptedException, IOException {
        // 创建一个与服务器的连接
        ZooKeeper zk = new ZooKeeper("localhost:2181",
                500000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("已经触发了" + event.getType() + "事件！");
            }
        });
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath",true));
//        System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true) + "]");
        System.out.println("===================");
        TimeUnit.HOURS.sleep(1);

        // 关闭连接
        zk.close();
    }
}
