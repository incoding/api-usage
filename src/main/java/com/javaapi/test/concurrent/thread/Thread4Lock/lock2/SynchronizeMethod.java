package com.javaapi.test.concurrent.thread.Thread4Lock.lock2;

public class SynchronizeMethod {
	/**
	 * 1 加了synchronized,这段代码肯定是串行的.
	 * 2 Thread.sleep 是不会释放同步监听器的 
	 * 另外suspend也不会释放,但是最好不要用.
     *
     *
     *
     *
     * 如果采用method级别的同步，则对象锁即为method所在的对象，如果是静态方法，
     * 1 对象锁即指method所在的 Class对象(唯一)；
     * 2 对象锁就是所有实例(这里有个小trick实例与Class调用不会用同一个锁)
     * http://www.cnblogs.com/shipengzhi/articles/2223100.html

     */
	public  static synchronized void synchronizedMethod(int threadNo) {
		for (int i = 1; i < 10; i++) {
			try {
				System.out.println("No." + threadNo + ":" + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
    public  synchronized void objectSynchronizedMethod(int threadNo) {
        for (int i = 1; i < 10; i++) {
            try {
                System.out.println("No." + threadNo + ":" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
