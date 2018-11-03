package com.javaapi.test.util.math.arith.Algorithm.Digui;

import java.util.ArrayList;
import java.util.List;

public class Xxx {
    String filePath = Xxx.class.getResource("").getPath() + "/zhushu.txt";
    List<Integer> listCure = new ArrayList<Integer>();
    int count = 0;

    public Xxx(int n) {
        for (int i = 1; i <= n; i++) {
            this.listCure.add(i);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Xxx xx = new Xxx(33);
        xx.getGroup(0, 6, xx.listCure.size(), null, xx);
        System.out.println("---->" + xx.count);//1107568 //50063860
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
    }

    private void getGroup(int index, int chuan, int listSize, List<Integer> group, Xxx xx) {
        if (chuan == 0) {
            xx.count++;
            System.out.println(group);
            return;
        }
        for (int i = index; i <= listSize - chuan; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            if (null != group) {
                cur.addAll(group);
            }
            cur.add(i + 1);
            getGroup(i + 1, chuan - 1, listSize, cur, xx);
        }
    }
}
