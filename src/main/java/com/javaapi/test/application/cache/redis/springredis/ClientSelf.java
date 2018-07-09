package com.javaapi.test.application.cache.redis.springredis;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class ClientSelf {
//
//
//    public static final String NIHAO_QUEUEKEY = "nihaoQueuekey";
//    @Autowired
//	@Qualifier("redisTemplateJdk")
//	private RedisTemplate<Serializable,Serializable>  redisTemplateJdk;
//
//
//    @Test
//    public void testQueuePop() throws Exception {
//        String nihaoQueuekey = queuePop(NIHAO_QUEUEKEY);
//        System.out.println("nihaoQueuekey = " + nihaoQueuekey);
//    }
//    @Test
//    public void test() {
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        while (true) {
//            for (int i = 0; i < 100; i++) {
//                final Integer finalI = i;
//                executorService.submit(new Runnable() {
//                    @Override
//                    public void run() {
//                        Integer value1 = queuePush(NIHAO_QUEUEKEY, "value"+ finalI);
//                        System.out.println("放入队列成功 值= "+finalI);
//                    }
//                });
//            }
//        }
//
//    }
//
//    @Test
//    public void testPop() throws Exception {
//        ExecutorService executorTrans = Executors.newFixedThreadPool(100);
//        new Thread(()-> {
//            while (true) {
//                executorTrans.submit(() -> {
//                    String s = queuePop(NIHAO_QUEUEKEY);
//                    System.out.println("s = " + s);
//                });
//                try {
//                    TimeUnit.MILLISECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        try {
//            TimeUnit.HOURS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testQueue() throws Exception {
//        queuePush(NIHAO_QUEUEKEY, "value");
//    }
//
//    private Integer queuePush(final String key, final String value) {
//        Integer execute = redisTemplateJdk.execute(new RedisCallback<Integer>() {
//            @Override
//            public Integer doInRedis(RedisConnection connection) throws DataAccessException {
//                try {
//                    return connection.lPush(key.getBytes(), value.getBytes()).intValue();
//                } catch (Exception e) {
//                    return 0;
//                }
//            }
//        }, false);
//        return execute;
//    }
//
//    private String queuePop(final String key) {
//        String result = redisTemplateJdk.execute(new RedisCallback<String>() {
//            @Override
//            public String doInRedis(RedisConnection connection) throws DataAccessException {
//                byte[] bytes = connection.lPop(key.getBytes());
//                if (bytes == null) {
//                    return "";
//                }
//                try {
//                    return new String(bytes, "UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    return "";
//                }
//            }
//        }, false);
//        return result;
//    }
}

