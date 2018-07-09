package com.javaapi.test.test.dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Set的存储机制是equals与hashcode相结合的。
 * 一般ADD一个对象会先根据equals方法判断与其他对象是否相等，因为Set是不允许重复add的。
 * 如你不覆盖equals方法，JAVA默认所有的对象都是不同的，也就是它们的内存地址。
 * 假如你NEW一个对象，人，你认为只要它们名字相同就是同一个对象，此时你就需要覆盖equals方法了，否则同名也是两个对象。
 * java先通过equals方法判断存储位置，如果不同直接存入；如果通过equals方法比较现在要存入的对象与结合中的某个对象相等，那么它就会再根据hashcode来判断它们是否hashcode也相等，如果相等那就存不进去了，说明它们确实是同一个对象，不等就可存入。所以一般在写程序的时候,两个对象你认为它们不同就去覆盖equals方法。这样可以提高效率，不要让JAVA再去判断hashcode</br>
 * HashSet 1 先判断equals 2 再判断hashcode。
 */
/**
 * 
 * HashMap 1 先判断hash 2再判断equals
 */

public class HashTest {
    private static int j = 1;
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //    public int hashCode() {
    //        int a = j++;
    //        System.out.println(a);
    //        return a;
    //    }

    public int hashCode() {
        return i % 10;
    }

    /**
     * 测试hashset
     */
    //    public final static void main(String[] args) {
    //        HashTest a = new HashTest();
    //        HashTest b = new HashTest();
    //        a.setI(1);
    //        b.setI(1);
    //        Set<HashTest> set = new HashSet<HashTest>();
    //        set.add(a);
    //        set.add(b);
    //        System.out.println(a.hashCode() == b.hashCode());
    //        System.out.println(a.equals(b));
    //        System.out.println(set);
    //    }

    public static void main(String[] args) {
        HashTest a = new HashTest();
        HashTest b = new HashTest();
        a.setI(1);
        b.setI(1);
        Map<HashTest, String> map = new HashMap<>();
        map.put(a, "p1");
        map.put(b, "p2");
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(map);
        System.out.println(map.get(b));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HashTest other = (HashTest) obj;
        if (i != other.i)
            return false;
        return true;
    }

}