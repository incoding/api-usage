package com.javaapi.test.test.testType.object.perfermance;

import com.javaapi.test.test.testType.object.FromBean;
import com.javaapi.test.test.testType.object.ToBean;

public class BenchmarkTest {
    private int count;

    public BenchmarkTest(int count) {
        this.count = count;
        System.out.println("性能测试" + this.count + "==================");
    }

    public void benchmark(IMethodCallBack m, FromBean frombean) {
        try {
            long begin = System.currentTimeMillis();
            ToBean tobean = null;
            System.out.println(m.getMethodName() + "开始进行测试");
            for (int i = 0; i < count; i++) {

                tobean = m.callMethod(frombean);

            }
            long end =  System.currentTimeMillis();
            System.out.println(m.getMethodName() + "耗时" + (end - begin)+"毫秒");
            System.out.println(tobean.getAddress());
            System.out.println(tobean.getAge());
            System.out.println(tobean.getIdno());
            System.out.println(tobean.getMoney());
            System.out.println(tobean.getName());
            System.out.println("                                      ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}