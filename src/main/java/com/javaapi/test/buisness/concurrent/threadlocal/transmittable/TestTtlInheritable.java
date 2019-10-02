package com.javaapi.test.buisness.concurrent.threadlocal.transmittable;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

/**
 * Created by user on 2019/9/28
 */
public class TestTtlInheritable {


    /**
     * 父线程给子线程传递值。
     * 这是其实是InheritableThreadLocal的功能，应该使用InheritableThreadLocal来完成。
     */
    @Test
    public void testInheritableThreadLocal() {
        InheritableRequestContext requestContext = new InheritableRequestContext();
        requestContext.setCount(111);
        Thread thread = new InheritableChildThread(requestContext);
        thread.setDaemon(true);
        thread.start();
    }

    @Data
    @AllArgsConstructor
    class InheritableChildThread extends Thread {
        private InheritableRequestContext requestContext;

        @Override
        public void run() {
            System.out.println("context count = " + requestContext.getCount());
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
}
