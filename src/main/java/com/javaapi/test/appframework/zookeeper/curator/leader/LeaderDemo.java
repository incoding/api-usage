package com.javaapi.test.appframework.zookeeper.curator.leader;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.cnblogs.com/francisYoung/p/5464789.html
 * LeaderLatch   (随机选取)
 * http://blog.csdn.net/smallnest/article/details/41895431/
 */
public class LeaderDemo {
    public static void main(String[] args) throws Exception {
        List<LeaderLatch> leaders = new ArrayList<LeaderLatch>();
        List<CuratorFramework> clients = new ArrayList<CuratorFramework>();

        TestingServer server = new TestingServer();


        try {
            for (int i = 0; i < 10; i++) {
                CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(), new ExponentialBackoffRetry(20000, 3));
                clients.add(client);

                LeaderLatch leader = new LeaderLatch(client, "/francis/leader");
                leader.addListener(new LeaderLatchListener() {

                    @Override
                    public void isLeader() {
                        // TODO Auto-generated method stub
                        System.out.println("I am Leader");
                    }

                    @Override
                    public void notLeader() {
                        // TODO Auto-generated method stub
                        System.out.println("I am not Leader");
                    }
                });


                leaders.add(leader);

                client.start();
                leader.start();
            }

            Thread.sleep(Integer.MAX_VALUE);
        } finally {

            for (CuratorFramework client : clients) {
                CloseableUtils.closeQuietly(client);
            }

            for (LeaderLatch leader : leaders) {
                CloseableUtils.closeQuietly(leader);
            }

            CloseableUtils.closeQuietly(server);
        }


        Thread.sleep(Integer.MAX_VALUE);
    }

}