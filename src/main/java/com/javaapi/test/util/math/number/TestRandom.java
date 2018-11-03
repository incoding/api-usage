package com.javaapi.test.util.math.number;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 */
public class TestRandom {
    /**
     *  GUID 在java中为uuid
     */
    @Test
    public void test(){
        UUID uuid = UUID.randomUUID();
        System.out.println("uuid = " + uuid.toString());
    }

    /**
     * 不好用
     * @throws Exception
     */
    @Test
    public void testName() throws Exception {
        int random = random(100);
        System.out.println("random = " + random);

    }

    static int random(int n) {
        final int offset = 123456;  // offset为固定值，避免被猜到种子来源（和密码学中的加salt有点类似）
        long seed = System.currentTimeMillis() + offset;
        SecureRandom secureRandom1;
        try {
            secureRandom1 = SecureRandom.getInstance("SHA1PRNG");

            secureRandom1.setSeed(seed);
            return secureRandom1.nextInt();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
