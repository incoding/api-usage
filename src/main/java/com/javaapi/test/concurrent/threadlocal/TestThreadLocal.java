package com.javaapi.test.concurrent.threadlocal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestThreadLocal extends Thread {
    private String ThreadId;

    // 如果世junit得test ，构造器只能有一个无参数的构造器
    public static void main(String[] args) {
        TestThreadLocal test1 = new TestThreadLocal("1");
        TestThreadLocal test2 = new TestThreadLocal("2");
        test1.start();
        //        test2.start();

    }
    @Override
    public void run() {
        if ("1".equals(getThreadId())) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("term", "140606==>" + getThreadId());
            ThreadLocalUtil.setLocal(map);
            ThreadLocalUtil.set(getThreadId(), getThreadId());
            ThreadLocalUtil.set(getThreadId(), 12356);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        getparam();
    }

    private void getparam() {
        Map<String, Object> resultmap = ThreadLocalUtil.getLocal();
        System.out.println(resultmap.get("term"));
        Integer term = ThreadLocalUtil.get(getThreadId());
        System.out.println(term);
    }
    public String getThreadId() {
        return ThreadId;
    }

    public void setThreadId(String threadId) {
        ThreadId = threadId;
    }

    public TestThreadLocal() {
    }
    public TestThreadLocal(String threadId) {
        super();
        ThreadId = threadId;
    }

}
