package com.javaapi.test.buisness.concurrent.threadpool.ThreadPool.getResult.completionservice;

import java.util.Random;
import java.util.concurrent.*;

import org.junit.Test;

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
}
