package com.javaapi.test.appframework.resilience.resilience4j.circuitbreaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.core.SupplierUtils;
import io.vavr.control.Try;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by user on 2020/4/21
 */
public class TestCircuitBreaker {

    /**
     * circuit 的精髓在于装饰decorate
     */
    @Test
    public void testDecorate() {
        TestCircuitBreaker testCircuitBreaker = new TestCircuitBreaker();
        CircuitBreaker circuitBreaker = CircuitBreakerRegistry.ofDefaults().circuitBreaker("name");

        Supplier<String> decoratedSupplier = CircuitBreaker
                .decorateSupplier(circuitBreaker, testCircuitBreaker::doSomething);

        String result = Try.ofSupplier(decoratedSupplier)
                           .recover(throwable -> "Hello from Recovery").get();
        System.out.println("result=" + result);
    }

    /**
     * 使用recover
     */
    @Test
    public void testDecorateRecover() {
        TestCircuitBreaker testCircuitBreaker = new TestCircuitBreaker();
        CircuitBreaker circuitBreaker = CircuitBreakerRegistry.ofDefaults().circuitBreaker("nameException");
        Supplier<String> decoratedSupplier = CircuitBreaker
                .decorateSupplier(circuitBreaker, testCircuitBreaker::doSomethingException);
        String result = Try.ofSupplier(decoratedSupplier)
                           .recover(throwable -> "Hello from Recovery").get();
        System.out.println("result=" + result);
    }


    @Test
    public void testRecover() {
        CircuitBreaker circuitBreaker = CircuitBreakerRegistry.ofDefaults().circuitBreaker("nameException");

        Supplier<String> supplier = () -> {
            System.out.println("method invoke");
            throw new RuntimeException("BAM!");
        };

        Supplier<String> supplierWithRecovery = SupplierUtils
                .recover(supplier, (exception) -> "Hello Recovery");

        String result = circuitBreaker.executeSupplier(supplierWithRecovery);

        System.out.println("result = " + result);
    }

    @Test
    public void testRecover2() {
//        Supplier<String> supplierWithResultAndExceptionHandler = SupplierUtils
//                .andThen(supplier, (result, exception) -> "Hello Recovery");
//
//        Supplier<HttpResponse> supplier = () -> httpClient.doRemoteCall();
//        Supplier<HttpResponse> supplierWithResultHandling = SupplierUtils.andThen(supplier, result -> {
//            if (result.getStatusCode() == 400) {
//                throw new ClientException();
//            } else if (result.getStatusCode() == 500) {
//                throw new ServerException();
//            }
//            return result;
//        });
//        HttpResponse httpResponse = circuitBreaker
//                .executeSupplier(supplierWithResultHandling);
    }


    /**
     * 模拟内部运作
     */
    @Test
    public void testCreate() {
        CircuitBreakerConfig build = CircuitBreakerConfig.custom().slidingWindowSize(3).build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("test", build);
        System.out.println("start");
        int i = 0;
        int j = 0;
        int k = 0;
        while (true) {
            try {
                circuitBreaker.acquirePermission();
            } catch (Exception e) {
                break;
            }
            try {

                invoke(i);
                circuitBreaker.onSuccess(1, TimeUnit.SECONDS);
                System.out.println("success------ = " + (k++));
            } catch (Exception e) {
                System.out.println("error------ = " + (j++));
                circuitBreaker.onError(1, TimeUnit.SECONDS, e);
            }
            System.out.println("count = " + (i++));
        }
        System.out.println("down");
    }

    public void invoke(int i) {
        if (i > 10) {
            throw new RuntimeException();
        }
//        throw new RuntimeException();
    }

    public String doSomething() {
        System.out.println("normal service");
        return "normal service";
    }

    public String doSomethingException() {
        System.out.println("do something");
        throw new RuntimeException();
    }

}
