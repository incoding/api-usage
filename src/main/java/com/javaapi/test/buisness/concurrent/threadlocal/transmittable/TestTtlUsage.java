package com.javaapi.test.buisness.concurrent.threadlocal.transmittable;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * refer
 * https://github.com/alibaba/transmittable-thread-local#-%E9%9C%80%E6%B1%82%E5%9C%BA%E6%99%AF
 * 1 父线程生成,包装后,再修改父线程值,子线程可以实时获取到么 ?
 * 2 父线程生成,包装后,修改子线程值,父线程可以实时获取到么? 是浅拷贝,普通pojo可以,
 * 但是Integer这种类型是final的因为传参时候不会变所以不可以
 */
public class TestTtlUsage {


    public static final int CORE_SIZE = 10;
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_SIZE, 20, 1000, TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(100));

    /**
     * 父线程生成,包装后,再修改父线程值,子线程可以实时获取到么 ? Integer 不可以
     */
    @Test
    public void testTaskWrapper() {
        initCoreSize();
        InheritableRequestContext requestContext = new InheritableRequestContext();
        requestContext.setCount(111);
        Runnable task = new Task(requestContext);
        // 额外的处理，生成修饰了的对象ttlRunnable
        Runnable ttlRunnable = TtlRunnable.get(task);
        // 之后修改是无法生效的
        requestContext.setCount(122);
        executor.submit(ttlRunnable);
    }

    /**
     * 父线程生成,包装后,再修改父线程值,子线程可以实时获取到么 ? 对象类型,不可以
     */
    @Test
    public void testTaskWithObjWrapper() {
        initCoreSize();
        InheritableRequestObjectContext requestContext = new InheritableRequestObjectContext();
        requestContext.setPerson(new Person("kk", 30));
        Runnable task = new TaskWithObj(requestContext);
        // 额外的处理，生成修饰了的对象ttlRunnable
        Runnable ttlRunnable = TtlRunnable.get(task);
        // 之后修改是无法生效的
        requestContext.setPerson(new Person("kka", 31));
        executor.submit(ttlRunnable);
    }


    /**
     * 其他任务是无法获取到 线程变量的
     */
    @Test
    public void testTaskWrapper2() {
        initCoreSize();
        InheritableRequestContext requestContext = new InheritableRequestContext();
        requestContext.setCount(111);
        Runnable task = new Task(requestContext);
        // 额外的处理，生成修饰了的对象ttlRunnable
        Runnable ttlRunnable = TtlRunnable.get(task);
        executor.submit(ttlRunnable);
        Runnable task2 = new Task(requestContext);
        executor.submit(task2);
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 父线程生成,包装后,修改子线程值,父线程可以实时获取到么? 跟对象有关,类似Integer这种带final的不可以
     */
    @Test
    public void testTaskWrapper3() {
        initCoreSize();
        InheritableRequestContext requestContext = new InheritableRequestContext();
        requestContext.setCount(111);
        Runnable task = new SubTaskModify(requestContext);

        Runnable ttlRunnable = TtlRunnable.get(task);
        executor.submit(ttlRunnable);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("requestContext=" + requestContext.getCount());
    }

    /**
     * 父线程生成,包装后,修改子线程值,父线程可以实时获取到么? 跟对象有关,普通pojo可以
     */
    @Test
    public void testTaskWithObjWrapper3() {
        initCoreSize();
        InheritableRequestObjectContext requestContext = new InheritableRequestObjectContext();
        requestContext.setPerson(new Person("kk", 30));
        Runnable task = new SubTaskWithObjModify(requestContext);

        Runnable ttlRunnable = TtlRunnable.get(task);
        executor.submit(ttlRunnable);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("requestContext=" + requestContext.getPerson());
    }


    @Data
    @AllArgsConstructor
    class Task implements Runnable {
        private InheritableRequestContext requestContext;

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("threadname=" + name + " context count = " + requestContext.getCount());
        }
    }

    @Data
    @AllArgsConstructor
    class TaskWithObj implements Runnable {
        private InheritableRequestObjectContext requestContext;

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("threadname=" + name + " context count = " + requestContext.getPerson());
        }
    }

    @Data
    @AllArgsConstructor
    class SubTaskModify implements Runnable {
        private InheritableRequestContext requestContext;

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("threadname=" + name + " context count = " + requestContext.getCount());
            requestContext.setCount(2);
        }
    }


    @Data
    @AllArgsConstructor
    class SubTaskWithObjModify implements Runnable {
        private InheritableRequestObjectContext requestContext;

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("threadname=" + name + " context count = " + requestContext.getPerson());
            requestContext.getPerson().setName("kk after");
        }
    }


    @Data
    private class InheritableRequestContext {
        private TransmittableThreadLocal<Integer> ttl = new TransmittableThreadLocal<>();

        public Integer getCount() {
            return ttl.get();
        }

        public void setCount(Integer count) {
            ttl.set(count);
        }
    }

    @Data
    private class InheritableRequestObjectContext {
        private TransmittableThreadLocal<Person> ttl = new TransmittableThreadLocal<>();

        public Person getPerson() {
            return ttl.get();
        }

        public void setPerson(Person person) {
            ttl.set(person);
        }
    }

    @Data
    @AllArgsConstructor
    private class Person {
        private String name;
        private Integer age;
    }

    /**
     * 初始化核心线程池, 避免新建线程.也就是模拟已经创建好线程的线程池
     */
    private void initCoreSize() {
        for (int i = 0; i < CORE_SIZE; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread=" + Thread.currentThread().getName() + " =" + finalI);
                }
            });

        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
