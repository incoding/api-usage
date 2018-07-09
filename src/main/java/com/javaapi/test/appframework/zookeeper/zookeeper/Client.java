package com.javaapi.test.appframework.zookeeper.zookeeper;

import org.apache.zookeeper.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 http://www.cnblogs.com/ggjucheng/p/3370359.html
 */
public class Client {

    private ZooKeeper zk;

    @Before
    public void forInit() throws IOException {
        zk = new ZooKeeper("127.0.0.1:2181", 500000, new Watcher() {
            // 监控所有被触发的事件
            public void process(WatchedEvent event) {
                System.out.println("1-已经触发了" + event.getType() + "事件！");
            }
        });
    }
    @After
    public void forAfter() throws InterruptedException {
        zk.close();
    }

    @Test
    public void testCreateParent() throws Exception {
        // 创建一个目录节点
        zk.create("/testRootPath", "testRootData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
    }
    @Test
    public void testGetData() throws Exception {
        // 创建一个目录节点
        System.out.println(new String(zk.getData("/testRootPath", false, null)));
    }

    @Test
    public void testCreateChild() throws Exception {
        // 创建一个子目录节点
        zk.create("/testRootPath/testChildPathOne", "testChildDataOne".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
    @Test
    public void testCreateChild2() throws Exception {
        // 创建另外一个子目录节点
        zk.create("/testRootPath/testChildPathTwo", "testChildDataTwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo", true, null)));
    }
    @Test
    public void testGetChildren() throws Exception {
        // 取出子目录节点列表
        System.out.println(zk.getChildren("/testRootPath", true));
    }

    @Test
    public void testSetData() throws Exception {
        // 取出子目录节点列表
        // 修改子目录节点数据
        zk.setData("/testRootPath/testChildPathOne", "modifyChildDataOne".getBytes(), -1);
        System.out.println("目录节点状态：[" + zk.exists("/testRootPath", true) + "]");
    }

    @Test
    public void testDeleteParent() throws IOException, KeeperException, InterruptedException {
        // 不能直接删除父节点,先删除所有子节点才能删除父节点
        zk.delete("/testRootPath", -1);
    }
    @Test
    public void testDeleteChild1() throws IOException, KeeperException, InterruptedException {
        // 删除子目录节点
        zk.delete("/testRootPath/testChildPathOne", -1);
    }
    @Test
    public void testDeleteChild2() throws IOException, KeeperException, InterruptedException {
        // 删除子目录节点
        zk.delete("/testRootPath/testChildPathTwo", -1);
    }

    @Test
    public void testSubscribe() throws IOException, KeeperException, InterruptedException {
        zk.register(new Watcher() {
            @Override
            public void process(WatchedEvent event) {

            }
        });
    }
}
