package com.javaapi.test.appframework.zookeeper.curator.leader;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.utils.EnsurePath;

/**
 *
 *  *  http://www.cnblogs.com/seaspring/p/5536338.html

 * Curator framework's leader election test.
 * Output:
 *  LeaderSelector-2 take leadership!
 *  LeaderSelector-2 relinquish leadership!
 *  LeaderSelector-1 take leadership!
 *  LeaderSelector-1 relinquish leadership!
 *  LeaderSelector-0 take leadership!
 *  LeaderSelector-0 relinquish leadership!
 *      ...
 *
 *      ========
 *      公平选举
 *      在这里我们使用AtomicInteger来记录此client获得领导权的次数， 它是”fair”， 每个client有平等的机会获得领导权。
 *      http://blog.csdn.net/smallnest/article/details/41895431/
 *


 *
 */
public class CuratorLeaderTest {

    /** Zookeeper info */
    private static final String ZK_ADDRESS = "localhost:2181";
    private static final String ZK_PATH = "/zktest";

    public static void main(String[] args) throws InterruptedException {
        LeaderSelectorListener listener = new LeaderSelectorListener() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                System.out.println(Thread.currentThread().getName() + " take leadership!");

                // takeLeadership() method should only return when leadership is being relinquished.
                Thread.sleep(5000L);

                System.out.println(Thread.currentThread().getName() + " relinquish leadership!");
            }

            @Override
            public void stateChanged(CuratorFramework client, ConnectionState state) {
            }
        };

        new Thread(() -> {
            registerListener(listener);
        }).start();

        new Thread(() -> {
            registerListener(listener);
        }).start();

        new Thread(() -> {
            registerListener(listener);
        }).start();

        Thread.sleep(Integer.MAX_VALUE);
    }

    private static void registerListener(LeaderSelectorListener listener) {
        // 1.Connect to zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();

        // 2.Ensure path
        try {
            new EnsurePath(ZK_PATH).ensure(client.getZookeeperClient());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3.Register listener
        LeaderSelector selector = new LeaderSelector(client, ZK_PATH, listener);
        selector.autoRequeue();
        selector.start();
    }

}