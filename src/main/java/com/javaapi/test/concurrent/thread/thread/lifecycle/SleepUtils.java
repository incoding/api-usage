package com.javaapi.test.concurrent.thread.thread.lifecycle;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 18/5/1
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds) ;
        } catch (InterruptedException e) {
        }
    }
}
