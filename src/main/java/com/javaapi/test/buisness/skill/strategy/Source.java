package com.javaapi.test.buisness.skill.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 16/5/30.
 */
public class Source {

    private static Map<Integer, SourceStrategy> mapStrategy = new HashMap<>();

    private static final SourceStrategy successStrategy = new SuccessStrategy();
    private static final SourceStrategy failStrategy = new FailStrategy();

    private int status;
    private SourceStrategy currentStrategy;

    public Source(int status) {
        this.status = status;
        currentStrategy = mapStrategy.get(status);
    }

    public Source() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    static {
        mapStrategy.put(1, successStrategy);
        mapStrategy.put(0, failStrategy);
    }


    public interface SourceStrategy {
        public boolean getStrategy(int status);
    }

    public static class SuccessStrategy implements SourceStrategy {

        @Override
        public boolean getStrategy(int status) {
            if (status == SourceStatus.SUCCESS) {
                return true;
            }
            return false;
        }
    }

    public static class FailStrategy implements SourceStrategy {

        @Override
        public boolean getStrategy(int status) {
            if (status == SourceStatus.FAIL) {
                return true;
            }
            return false;
        }
    }

    public boolean check(int status) {
        return currentStrategy.getStrategy(status);
    }


    public static final class SourceStatus {
        public static final int SUCCESS = 1;
        public static final int FAIL = 0;
    }
}
