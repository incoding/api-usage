package com.javaapi.test.test.dataStructure.map.hashmap;

import org.junit.Test;

import java.util.*;

/**
 * http://www.cnblogs.com/hubingxu/archive/2012/02/21/2361281.html</br>
 * 一般情况下，我们用的最多的是HashMap,在Map 中插入、删除和定位元素，HashMap
 * 是最好的选择。但如果您要按自然顺序或自定义顺序遍历键，那么TreeMap会更好。如果需要输出的顺序和输入的相同,那么用LinkedHashMap
 * 可以实现,它还可以按读取顺序来排列.
 * 
 */
public class TestHashMap {

	@Test
	public void testHashMap() {
		HashMap<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("1", "2");
		System.out.println(map.get("1"));
	}

    /**
     * hash 后取模
     */
    @Test
    public void testOrder() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "6");
        map.put(8, "6");
        map.put(9, "6");
        map.put(17, "6");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println("key = " + key+"value="+value);
        }
    }

    @Test
    public void testHashMapSize() {
        HashMap<String, String> map = new HashMap<>(1000);
        map.put("1", "1");
        map.put("1", "2");
        System.out.println(map.get("1"));
    }

    @Test
    public void testHashMapMerge() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map.put("1", 1);
        map.put("2", 2);
        map1.put("2", 22);
        map1.put("3", 3);
        map1.put("4", 4);
        map.putAll(map1);
        System.out.println(map);
    }
    @Test
    public void testHashMapRemove() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map.put("1", 1);
        map.put("2", 2);
        map1.put("2", 22);
        map1.put("3", 3);
        map1.put("4", 4);
        map.putAll(map1);
        map.remove("2");
        System.out.println(map);
    }

    @Test
    public void testHashMapRemove2() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("2", 2);
        map.remove("2");
        map.remove("3");
        System.out.println(map);
    }
    @Test
    public void testHashMapPutAll() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map.put("1", 1);
        map.put("2", 2);
        map1.put("2", 22);
        map1.put("3", 3);
        map1.put("4", 4);
        map.putAll(map1);
        System.out.println(map);
    }
    @Test
    public void testHashMapInit() {
        List<String> input =new ArrayList<>();
        input.add("nihao");
        input.add("nihao");
        input.add("nihao");
        input.add("nihao");
        input.add("nihao");
        input.add("nihao");
        input.add("nihao");
        int mapSize = (int)Math.ceil(input.size() / 0.7);
        
        Map<String,String> map = new HashMap<String, String>(mapSize); 
        for(String f: input)
        {
            map.put("key", f);
        }
    }

    /**
     * 所以，在存储大容量数据的时候，最好预先指定hashmap的size为2的整数次幂次方。就算不指定的话，也会以大于且最接近指定值大小的2次幂来初始化的
     * @throws Exception
     */
    @Test
    public void testTableSizeFor() throws Exception {
        int i = tableSizeFor(1000);
        System.out.println("i = " + i);
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
