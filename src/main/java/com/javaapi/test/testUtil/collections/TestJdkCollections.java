package com.javaapi.test.testUtil.collections;

import org.junit.Test;

import java.util.*;

/**
 * Created by user on 15/9/6.
 */
public class TestJdkCollections {
    @Test
    public void testSort() {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(1);
        list.add(3);
        System.out.println("list = " + list);
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("key", list);
        List<Integer> newList = map.get("key");
        Collections.sort(newList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("newList = " + newList);
        System.out.println(list == newList);
    }

    @Test
    public void testClear() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(3);
        list.clear();
        list.add(5);
        System.out.println(list);
    }

    @Test
    public void testReverse(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(3);
        System.out.println("list = " + list);
        ArrayList<Integer> newList = new ArrayList<>(list);
        System.out.println("newList 等于 list内存地址么 ?=" + (newList==list));

        Collections.reverse(newList);
        System.out.println("newList = " + newList);
    }

    @Test
    public void testSubList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> integers = list.subList(3, list.size());
        System.out.println("integers = " + integers);
    }


}
