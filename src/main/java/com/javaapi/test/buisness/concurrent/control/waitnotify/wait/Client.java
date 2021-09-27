package com.javaapi.test.buisness.concurrent.control.waitnotify.wait;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * 里面有典型的wait notify 机制代码,也就是本实例
 * kk注释: 生产消费者是基于wait notify机制的
 * http://zhangjunhd.blog.51cto.com/113473/71387
 * 1  调用sleep()和yield()的时候锁并没有被释放(进入阻塞状态)，而调用wait()将释放锁(进入等待状态)。        释放锁以方便下一个A线程wait,或者B线程notify
   1.2      当B调用obj.notify/notifyAll的时候，B正持有obj锁，因此，A1,A2,A3虽被唤醒，但是仍无法获得obj锁。直到B退出synchronized块，释放obj锁后，A1,A2,A3中的一个才有机会获得锁继续执行。
 *
 *
 *
 * 锁状态转换关系
 *  http://uule.iteye.com/blog/1100799
 */
public class Client {

    @Test
    public void test() {
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            game.addPlayer(new Athlete(i, game));
        }
        new Thread(game).start();
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**synchronize 和wait 是好搭档
     * 只能在同步控制方法或同步块中调用wait()、notify()和notifyAll()。如果在非同步的方法里调用这些方法，在运行时会抛出IllegalMonitorStateException异常。
     */
    @Test
    public void test2() {
        Object o = new Object();
        try {
            o.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
