package com.javaapi.test.buisness.skill.bit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayListImp {
    @Test
    public void Test() {
        List<String> a = new ArrayList<String>();
        a.add("feature1");
        a.add("feature2");
        a.add("feature3");
        List<String> b = new ArrayList<String>();
        a.add("feature1");
        a.add("feature2");
        a.add("feature6666");
        System.out.println(a.containsAll(b));

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("2", "2");
        System.out.println(map.containsKey("3"));

    }
}
