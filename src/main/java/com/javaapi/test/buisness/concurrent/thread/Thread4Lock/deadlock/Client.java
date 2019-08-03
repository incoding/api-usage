package com.javaapi.test.buisness.concurrent.thread.Thread4Lock.deadlock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * VM Thread" os_prio=31 tid=0x00007ff517809000 nid=0x2c03 runnable

 "GC task thread#0 (ParallelGC)" os_prio=31 tid=0x00007ff51700d000 nid=0x1d07 runnable

 "GC task thread#1 (ParallelGC)" os_prio=31 tid=0x00007ff51700e000 nid=0x2003 runnable

 "GC task thread#2 (ParallelGC)" os_prio=31 tid=0x00007ff516803800 nid=0x2a03 runnable

 "GC task thread#3 (ParallelGC)" os_prio=31 tid=0x00007ff516811000 nid=0x5403 runnable

 "VM Periodic Task Thread" os_prio=31 tid=0x00007ff518211000 nid=0x3c03 waiting on condition

 JNI global references: 2319


 Found one Java-level deadlock:
 =============================
 "线程B":
 waiting to lock monitor 0x00007ff5174a4608 (object 0x00000007962b3698, a com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassA),
 which is held by "线程A"
 "线程A":
 waiting to lock monitor 0x00007ff51803b758 (object 0x00000007962b88c0, a com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassB),
 which is held by "线程B"

 Java stack information for the threads listed above:
 ===================================================
 "线程B":
 at com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassA.a2(ClassA.java:20)
 - waiting to lock <0x00000007962b3698> (a com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassA)
 at com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassB.b1(ClassB.java:15)
 - locked <0x00000007962b88c0> (a com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassB)
 at com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.Client$2.run(Client.java:24)
 at java.lang.Thread.run(Thread.java:745)
 "线程A":
 at com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassB.b2(ClassB.java:19)
 - waiting to lock <0x00000007962b88c0> (a com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassB)
 at com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassA.a1(ClassA.java:16)
 - locked <0x00000007962b3698> (a com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.ClassA)
 at com.javaapi.test.concurrent.Thread.Thread4Lock.deadlock.Client$1.run(Client.java:18)
 at java.lang.Thread.run(Thread.java:745)

 Found 1 deadlock.

 */
public class Client {
    @Test
    public void test() {
        final ClassA a = new ClassA();
        final ClassB b = new ClassB();
        new Thread(new Runnable() {
            @Override
            public void run() {
                a.a1(b);
            }
        },"线程A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                b.b1(a);
            }
        },"线程B").start();
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
