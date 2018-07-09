package com.javaapi.test.testUtil.math.arith.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class NofM {
    private int m;
    private int[] set;
    private boolean first;
    private int position;

    public NofM(int n, int m) {
        this.m = m;
        first = true;
        position = n - 1;

        set = new int[n];
        for (int i = 0; i < n; i++)
            set[i] = i + 1;
    }

    public boolean hasNext() {
        return set[0] < m - set.length + 1;
    }

    public int[] next() {
        if (first) {
            first = false;
            return set;
        }

        if (set[set.length - 1] == m)
            position--;
        else
            position = set.length - 1;

        set[position]++;

        // 调整右边元素 
        for (int i = position + 1; i < set.length; i++)
            set[i] = set[i - 1] + 1;

        return set;
    }

    public static void main(String[] args) {
        NofM nOfm = new NofM(6, 33);
        List<String> list = new ArrayList<>();
        while (nOfm.hasNext()) {
            int[] set = nOfm.next();
            for (int i = 0; i < set.length; i++) {
                System.out.print(set[i]);
            }
            System.out.println();
            list.add(set + "");
        }
        System.out.println("result==>" + list.size());
    }
}