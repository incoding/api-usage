package com.javaapi.test.concurrent.threadpool.ThreadPool.queueStrategy;

import com.javaapi.test.concurrent.threadpool.ThreadPool.rejectStrategy.TestThreadPoolRejectHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 17/6/14.
 */
public class ThreadPoolTest {

    public static final int CORE_SIZE = 6;
    public static final int MAX_SIZE = 10;
    public static final int QUEUE_SIZE = 15;
    /**
     * 额外多出来的
     */
    public static final int REDUNDANT = 5;
    /**
     * 通用的
     */
    public ThreadPoolExecutor common = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(QUEUE_SIZE));



    public void checkEsStatus(ThreadPoolExecutor es, int queueSize, int maxSize, int redundant) {
        int size = queueSize + maxSize + redundant;
        printStats(es);
        for (int i = 0; i < size; i++) {
            es.submit(new TestThreadPoolRejectHandler.Job(String.valueOf(i)));
            printStats(es);
        }
        System.out.println("------------");
        while (es.getActiveCount() != 0) {
            printStats(es);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printStats(ThreadPoolExecutor es) {
        int activeCount = es.getActiveCount();
        int corePoolSize = es.getCorePoolSize();
        int maximumPoolSize = es.getMaximumPoolSize();
        int queueSize = es.getQueue().size();

        long taskCount = es.getTaskCount();//线程池需要执行的任务数量
        long completedTaskCount = es.getCompletedTaskCount();//线程池在运行过程中已完成的任务数量。小于或等于taskCount
        int everLargest = es.getLargestPoolSize();//线程池曾经创建过的最大线程数量。通过这个数据可以知道线程池是否满过。如等于线程池的最大大小，则表示线程池曾经满了。
        int poolSize = es.getPoolSize();//线程池的线程数量。如果线程池不销毁的话，池里的线程不会自动销毁，所以这个大小只增不减。
        Map<String, String> map = new HashMap<>();
        map.put("activeCount", String.valueOf(activeCount));
        map.put("corePoolSize", String.valueOf(corePoolSize));
        map.put("maximumPoolSize", String.valueOf(maximumPoolSize));
        map.put("queueSize", String.valueOf(queueSize));
        map.put("everLargest", String.valueOf(everLargest));
        String coreIsFull;
        if (activeCount >= corePoolSize) {
            coreIsFull = " corePoolSize is full ";
        } else {
            coreIsFull = "";
        }
        String maxIsFull = null;
        if (activeCount >= maximumPoolSize) {
            maxIsFull = " maximumPoolSize is full ";
        } else {
            maxIsFull = "";
        }
        String queueIsFull = null;
        if (queueSize == QUEUE_SIZE) {
            queueIsFull = " queueSize is full ";
        } else {
            queueIsFull = "";
        }
        String join = StringUtils.join(new String[]{String.valueOf("everLargest = "+everLargest),coreIsFull, queueIsFull, maxIsFull}, "|");
        System.out.println("queueSize = " + map + join);
    }


    public static class Job implements Runnable {
        private String jobId ;

        public Job(String jobId) {
            this.jobId = jobId;
        }

        public Job() {
        }

        @Override
        public void run() {
            try {
                int timeout = 10000;
                TimeUnit.HOURS.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getJobId() {
            return jobId;
        }

        public void setJobId(String jobId) {
            this.jobId = jobId;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "jobId='" + jobId + '\'' +
                    '}';
        }
    }
}
