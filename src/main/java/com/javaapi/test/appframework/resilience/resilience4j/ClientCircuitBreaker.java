package com.javaapi.test.appframework.resilience.resilience4j;

import com.javaapi.test.buisness.exception.bussiness.exception.exception.BusinessException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.core.SupplierUtils;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class ClientCircuitBreaker {
    @Resource
    BackendService backendService;

    @Test
    public void test() {
        CircuitBreaker circuitBreaker = getCircuitBreaker();
        String result = circuitBreaker
                .executeSupplier(backendService::doSomething);
        System.out.println("result = " + result);

    }

    /**
     * 给定碰到异常后的,恢复逻辑
     */
    @Test
    public void testRecover() {
        // Given
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("testName");

        // When I decorate my function and invoke the decorated function
        CheckedFunction0<String> checkedSupplier =
                CircuitBreaker.decorateCheckedSupplier(circuitBreaker, () -> {
                    throw new RuntimeException("BAM!");
                });
        Try<String> result = Try.of(checkedSupplier)
                                .recover(throwable -> "Hello Recovery");

        System.out.println("result = " + result.isSuccess());
        System.out.println("result = " + result.get());
    }

    /**
     * If you want to recover from an exception before the CircuitBreaker records it as a failure, you can do the following:
     */
    @Test
    public void testRecover2() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("testName");

        Supplier<String> supplier = () -> {
            throw new RuntimeException("BAM!");
        };

        Supplier<String> supplierWithRecovery = SupplierUtils
                .recover(supplier, (exception) -> "Hello Recovery");

        String result = circuitBreaker.executeSupplier(supplierWithRecovery);

        System.out.println("result = " + result);

    }

    private CircuitBreaker getCircuitBreaker() {
        // Create a custom configuration for a CircuitBreaker
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                                                                        .failureRateThreshold(50)
                                                                        .waitDurationInOpenState(Duration.ofMillis(1000))
                                                                        .permittedNumberOfCallsInHalfOpenState(2)
                                                                        .slidingWindowSize(2)
                                                                        .recordExceptions(IOException.class, TimeoutException.class)
                                                                        .ignoreExceptions(BusinessException.class, BusinessException.class)
                                                                        .build();

// Create a CircuitBreakerRegistry with a custom global configuration
        CircuitBreakerRegistry circuitBreakerRegistry =
                CircuitBreakerRegistry.of(circuitBreakerConfig);

        CircuitBreaker circuitBreaker = circuitBreakerRegistry
                .circuitBreaker("name");
        return circuitBreaker;
    }
}
