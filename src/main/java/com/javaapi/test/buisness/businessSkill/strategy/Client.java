package com.javaapi.test.buisness.businessSkill.strategy;

import org.junit.Test;

/**
 * 策略模式 strage
 */
public class Client {
    @Test
    public void test() {
        Source source = new Source(1);
        if (source.getStatus() == Source.SourceStatus.SUCCESS) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    @Test
    public void testCheck() throws Exception {
        Source source = new Source(1);
        boolean check = source.check(1);
        System.out.println("check = " + check);
         check = source.check(0);
        System.out.println("check = " + check);

    }
}
