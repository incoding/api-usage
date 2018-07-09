package com.javaapi.test.spring.zotherFeature.scheduler.quartz2.original.concurrent;

import com.javaapi.test.spring.zotherFeature.scheduler.quartz2.original.QuartzManager;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 *
 * http://www.cnblogs.com/Rozdy/p/4220186.html
 * Quartz定时任务默认都是并发执行的，不会等待上一次任务执行完毕，只要间隔时间到就会执行, 如果定时任执行太长，会长时间占用资源，导致其它任务堵塞。
 1.在Spring中这时需要设置concurrent的值为false, 禁止并发执行。

 <property name="concurrent" value="true" />
 2.当不使用spring的时候就需要在Job的实现类上加@DisallowConcurrentExecution的注释
 @DisallowConcurrentExecution 禁止并发执行多个相同定义的JobDetail, 这个注解是加在Job类上的, 但意思并不是不能同时执行多个Job, 而是不能并发执行同一个Job Definition(由JobDetail定义), 但是可以同时执行多个不同的JobDetail, 举例说明,我们有一个Job类,叫做SayHelloJob, 并在这个Job上加了这个注解, 然后在这个Job上定义了很多个JobDetail, 如sayHelloToJoeJobDetail, sayHelloToMikeJobDetail, 那么当scheduler启动时, 不会并发执行多个sayHelloToJoeJobDetail或者sayHelloToMikeJobDetail, 但可以同时执行sayHelloToJoeJobDetail跟sayHelloToMikeJobDetail

 @PersistJobDataAfterExecution 同样, 也是加在Job上,表示当正常执行完Job后, JobDataMap中的数据应该被改动, 以被下一次调用时用。当使用@PersistJobDataAfterExecution 注解时, 为了避免并发时, 存储数据造成混乱, 强烈建议把@DisallowConcurrentExecution注解也加上。


 */
public class TestQuartz {

    public static String JOB_NAME = "动态任务调度";
    public static String TRIGGER_NAME = "动态任务触发器";
    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";
    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";



    /**
     * 测试  并发执行
     */
    @Test
    public void testConcurrent() {
        try {
            System.out.println("【系统启动】开始(每5秒输出一次)...");
            QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, MyJobConcurrent.class, "0/5 * * * * ?");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * 测试  非并发执行,
     * 比如开始0秒 , 那么第二个任务应该5秒会发生
     * 但是第一个任务经过8秒才完成,   此时第二个任务会立刻执行,所以第二个任务是在8秒执行
     *
     * 相当于执行完立刻又执行
     *
     *Fri Nov 03 19:26:20 CST 2017: doing something...
     Fri Nov 03 19:26:28 CST 2017: doing something...
     Fri Nov 03 19:26:36 CST 2017: doing something...
     Fri Nov 03 19:26:44 CST 2017: doing something...
     Fri Nov 03 19:26:52 CST 2017: doing something...
     Fri Nov 03 19:27:00 CST 2017: doing something...
     Fri Nov 03 19:27:08 CST 2017: doing something...
     *
     */
    @Test
    public void testNonConcurrent() {
        try {
            System.out.println("【系统启动】开始(每5秒输出一次)...");
            QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, MyJobNonConcurrent.class, "0/5 * * * * ?");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}