package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.getResult.completionservice;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.testng.collections.Lists;

/**CompletionService</br>
 *我们可以根据执行结束的顺序获取对应的结果
 * https://my.oschina.net/jielucky/blog/158839
 *
 */
public class Client {
	@Test
	public void testComplete() throws Exception {
		ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
				threadPool1);
		for (int i = 1; i <= 10; i++) {
			final int seq = i;
			completionService.submit(new Callable<Integer>() {
				public Integer call() throws Exception {
					Thread.sleep(new Random().nextInt(5000));
					System.out.println("返回" + seq);
					return seq;
				}
			});
		}
		for (int i = 0; i < 10; i++) {
			Future<Integer> take = completionService.take();
			System.out.println(take.get());
		}
		System.out.println("done");
	}

    @Test
    public void testComplete2() throws Exception {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
                threadPool1);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 1; i <= 10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    int millis = new Random().nextInt(5000) + 5000;
                    Thread.sleep(millis);
                    System.out.println("返回" + seq + "消耗" + millis);
                    return seq;
                }
            });
        }
        Future<Integer> future = completionService.poll(1, TimeUnit.SECONDS);
        stopWatch.stop();
        System.out.println("stop = " + stopWatch.getTime());

        Integer integer = future.get(1, TimeUnit.SECONDS);
        System.out.println("integer = " + integer);
        System.out.println("done");
    }


    /**
     * 有一个总体超时时间
     *
     * @throws Exception
     */
    @Test
    public void testComplete3() throws Exception {
        ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(
                threadPool1);
        List<Future<Integer>> result = Lists.newArrayList();
        for (int i = 1; i <= 10; i++) {
            final int seq = i;
            int finalI = i;
            Future<Integer> submit = completionService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    int millis;
                    if (finalI == 1) {
                        millis = 15 * 1000;
                    } else {
                        millis = new Random().nextInt(5000) + 5000;
                    }

                    Thread.sleep(millis);
                    System.out.println("返回" + seq + "消耗" + millis);
                    return seq;
                }
            });
            result.add(submit);
        }
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        for (int i = 0; i < result.size(); i++) {
            long remainTimeOut = getRemainTimeOut(i, start);
            Future<Integer> future = completionService.poll(getRemainTimeOut(i, start), TimeUnit.MILLISECONDS);
            if (future == null) {
                System.out.println("超时break");
                break;
            }
            long futureStart = System.currentTimeMillis();
            // 这种情况下 是在completionService.poll 消耗时间,future.get基本立刻返回,所以future.get的超时时间设置任意即可
            Integer integer = future.get(1, TimeUnit.SECONDS);
            System.out.println("index = " + i + ",remain=" + remainTimeOut + ",result=" + integer + ",futureCost=" + (System.currentTimeMillis() - futureStart));

        }
        System.out.println("cost = " + (System.currentTimeMillis() - start));

    }

    /**
     * 保证
     * 获取剩余超时时间
     *
     * @param index
     * @return 超时毫秒数
     */
    private long getRemainTimeOut(int index, long start) {

        int timeOut = 10;
        long valiateTimeOut = timeOut * 1000;
        if (index == 0) {
            return valiateTimeOut;
        }
        long now = System.currentTimeMillis();
        long remainTimeOut = start + valiateTimeOut - now;
        System.out.println("index = " + index + ",remain=" + remainTimeOut);
        return remainTimeOut;
    }
}
