package com.javaapi.test.arithmetic.quchong;

import java.util.HashMap;
import java.util.Map;

public class Intersection {
  public static void main(String[] args) {
    Integer a[] = { 4, 7, 3, 6, 2 };
    Integer b[] = { 9, 0, 5, 7, 3 };
    Map<Integer, Integer> result = new HashMap<Integer, Integer>();
    for (Integer item : a) {
      if (result.get(item) != null) {
        result.put(item, result.get(item) + 1);
      } else {
        result.put(item, 1);
      }
    }
    for (Integer item : b) {
      if (result.get(item) != null) {
        result.put(item, result.get(item) + 1);
      } else {
        result.put(item, 1);
      }
    }
    for (Map.Entry<Integer, Integer> item : result.entrySet()) {
      Integer value = item.getValue();
      if (value.equals(2)) {
        System.out.println(item.getKey());
      }
    }
  }
}