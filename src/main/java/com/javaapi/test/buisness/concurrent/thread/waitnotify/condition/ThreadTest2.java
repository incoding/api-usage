package com.javaapi.test.buisness.concurrent.thread.waitnotify.condition;

import java.util.concurrent.TimeUnit;


/**http://blog.csdn.net/ghsau/article/details/7481142
 * condition ,用于帮助lock实现同步监听机制</br>
 *   在Condition中，用await()替换wait()，用signal()替换notify()，用signalAll()替换notifyAll()，传统线程的通信方式，Condition都可以实现，</br>
 *   这里注意，Condition是被绑定到Lock上的，要创建一个Lock的Condition必须用newCondition()方法。
 *   要调用同一把锁的await和signal才能生效
 *
 *   ---------------------------------------------------
 *   https://www.cnblogs.com/skywang12345/p/3496716.html
 * Condition除了支持上面的功能之外，它更强大的地方在于：能够更加精细的控制多线程的休眠与唤醒。对于同一个锁，我们可以创建多个Condition，在不同的情况下使用不同的Condition。
 例如，假如多线程读/写同一个缓冲区：当向缓冲区中写入数据之后，唤醒"读线程"；当从缓冲区读出数据之后，唤醒"写线程"；并且当缓冲区满的时候，"写线程"需要等待；当缓冲区为空时，"读线程"需要等待。         如果采用Object类中的wait(), notify(), notifyAll()实现该缓冲区，当向缓冲区写入数据之后需要唤醒"读线程"时，不可能通过notify()或notifyAll()明确的指定唤醒"读线程"，而只能通过notifyAll唤醒所有线程(但是notifyAll无法区分唤醒的线程是读线程，还是写线程)。  但是，通过Condition，就能明确的指定唤醒读线程。

 *
 *
 *
 */
public class ThreadTest2 {
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
				threadExecute(business, "sub");
			}
		}).start();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadExecute(business, "main");
	}	
	public static void threadExecute(Business business, String threadType) {
		for(int i = 0; i < 10; i++) {
			try {
				if("main".equals(threadType)) {
					business.main(i);
				} else {
					business.sub(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
