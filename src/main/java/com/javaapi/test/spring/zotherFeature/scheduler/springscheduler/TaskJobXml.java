package com.javaapi.test.spring.zotherFeature.scheduler.springscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//@Service

/**
 * job1       <task:scheduled ref="taskJobXml" method="job1" fixed-delay="5000"/>
 * <p>
 * 同一个方法不会并发执行
 * <p>
 * <p>
 * -------------
 */
public class TaskJobXml {

    private static int a = 0;

    public void job1() {

        System.out.println();
        String tmp = "";
        if (a % 2 == 0) {
            tmp = "偶数任务";
        } else {
            tmp = "奇数任务";
//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        a++;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sd.format(new Date());
        System.out.println(tmp + "线程名称:" + Thread.currentThread().getName() + "任务执行xml == >" + format + "==instance==>" + this);
    }

    /**
     * * 不同任务共享同一个实例,如果有一个任务耗时过长,则另一任务会等待该任务执行完毕才开始定时执行
     */
    public void job2() {

        if (a > 7) {
            return;
        }
        System.out.println();
        String tmp = "";
        if (a == 1) {
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tmp = "奇数任务";
        }
        if (a > 1) {
            tmp = "偶数任务";
        }

        a++;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sd.format(new Date());
        System.out.println(tmp + "线程名称:" + Thread.currentThread().getName() + "任务执行xml == >" + format + "==instance==>" + this);
    }

    /**
     * 多个任务不同实例不受影响
     */
    public void job3() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sd.format(new Date());
        System.out.println("线程名称:" + Thread.currentThread().getName() + "任务执行xml == >" + format + "==instance==>" + this);

    }


    public void job_init() {
        System.out.println("init xml");
    }
}