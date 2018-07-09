package com.javaapi.test.concurrent.thread.Thread4Lock.synchronizeLock;

import org.junit.Test;

/**
 * 关于线程同步的测试用例
 * 
 */
public class Client {

	/**
	 * 同步代码块,10个线程持有相同对象锁
	 */
	@Test
	public void synchronzeBlock() {
		String lock = new String("lock");
		for (int i = 1; i < 10; i++) {
			new SynchronizeBlockThread(i, lock).start();
		}

	}
    /**
     * 同步代码块,每个线程对象锁不同
     */
    @Test
    public void synchronzeBlockTmp() {
        for (int i = 1; i < 10; i++) {
            new SynchronizeBlockThreadTmp(i, null).start();
        }

    }

	/**
	 * 同步方法  synchronized 前有static修饰,  也就是说所有线程使用同一个锁
	 */
	/**
	 * 1 加了synchronized,这段代码肯定是串行的.
	 * 2 Thread.sleep 是不会释放同步监听器的 
	 * 另外suspend也不会释放,但是最好不要用.
	 */
	@Test
	public void synchronizeMethod() {
		String lock = new String("lock");
		for (int i = 1; i < 10; i++) {
			new SynchronizeMethodThread(i, lock).start();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1*60*60*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * http://www.cnblogs.com/shipengzhi/articles/2223100.html
     *
     *   pulbic class Something(){
     public synchronized void isSyncA(){}
     public synchronized void isSyncB(){}
     public static synchronized void cSyncA(){}
     public static synchronized void cSyncB(){}
     }
     那么，加入有Something类的两个实例a与b，那么下列组方法何以被1个以上线程同时访问呢 答案(b,d)
     a.   x.isSyncA()与x.isSyncB()
     b.   x.isSyncA()与y.isSyncA()
     c.   x.cSyncA()与y.cSyncB()
     d.   x.isSyncA()与Something.cSyncA()
     这里，很清楚的可以判断：
     a，都是对同一个实例的synchronized域访问，因此不能被同时访问
     b，是针对不同实例的，因此可以同时被访问
     c，因为是static synchronized，所以不同实例之间仍然会被限制,相当于Something.isSyncA()与   Something.isSyncB()了，因此不能被同时访问。
     那么，第d呢?，书上的 答案是可以被同时访问的，答案理由是synchronzied的是实例方法与synchronzied的类方法由于锁定（lock）不同的原因。
     个人分析也就是synchronized 与static synchronized 相当于两帮派，各自管各自，相互之间就无约束了，可以被同时访问。目前还不是分清楚java内部设计synchronzied是怎么样实现的。
     * @throws Exception
     */
    @Test
    public void testStaticSynchnorizeWithInstanceSynchnorized() throws Exception {


    }
}
