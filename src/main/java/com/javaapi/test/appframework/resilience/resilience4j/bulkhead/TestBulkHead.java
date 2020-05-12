package com.javaapi.test.appframework.resilience.resilience4j.bulkhead;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import org.junit.Test;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2020/4/25
 */
public class TestBulkHead {

    @Test
    public void testConfig() {
        BulkheadConfig config = BulkheadConfig.custom()
                                              .maxConcurrentCalls(150)
                                              .maxWaitDuration(Duration.ofMillis(500))
                                              .build();
        BulkheadRegistry registry = BulkheadRegistry.of(config);
        Bulkhead bulkheadWithDefaultConfig = registry.bulkhead("name1");
    }

    @Test
    public void testExecute() throws Exception {
        BulkheadConfig config = BulkheadConfig.custom()
                                              .maxConcurrentCalls(150)
                                              .maxWaitDuration(Duration.ofMillis(500))
                                              .build();
        BulkheadRegistry registry = BulkheadRegistry.of(config);
        Bulkhead bulkhead = registry.bulkhead("name1");
        bulkhead.executeRunnable(() -> {
        });

        bulkhead.executeCallable(() -> "");
    }

    @Test
    public void testDecorate() throws Exception {
        BulkheadConfig config = BulkheadConfig.custom()
                                              .maxConcurrentCalls(150)
                                              .maxWaitDuration(Duration.ofMillis(500))
                                              .build();
        BulkheadRegistry registry = BulkheadRegistry.of(config);
        Bulkhead bulkhead = registry.bulkhead("name1");
        Callable<String> stringCallable = Bulkhead.decorateCallable(bulkhead, () -> "");
    }

    @Test
    public void testExecuteThread() {
        BulkheadConfig config = BulkheadConfig.custom()
                                              .maxConcurrentCalls(2)
                                              .maxWaitDuration(Duration.ofMillis(500))
                                              .build();
        BulkheadRegistry registry = BulkheadRegistry.of(config);
        Bulkhead bulkhead = registry.bulkhead("name1");
        Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("execute run");
        });
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
