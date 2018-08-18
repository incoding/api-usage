package com.javaapi.test.test.dataStructure.map.hashmap;

import com.javaapi.test.buisness.skill.bit.base.TestBit3;
import org.junit.Test;

/**
 *   java 中HashMap是数组加链表实现的
 *   @see  com.javaapi.test.test.dataStructure.TestHash
 *   @see TestBit3
 */
public class TestHashMapDetail {



    /**
     * 所以，在存储大容量数据的时候，最好预先指定hashmap的size为2的整数次幂次方。就算不指定的话，也会以大于且最接近指定值大小的2次幂来初始化的
     * @throws Exception
     */
    @Test
    public void testInitialCapacity() throws Exception {
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

    /**
     *    那么hashmap什么时候进行扩容呢？
     *    当hashmap中的元素个数超过数组大小*loadFactor时，就会进行数组扩容，loadFactor的默认值为0.75，
     *    也就是说，默认情况下，
     *    数组大小为16，那么当hashmap中元素个数超过16*0.75=12的时候，就把数组的大小扩展为2*16=32，
     *    即扩大一倍，
     *    然后重新计算每个元素在数组中的位置
     *    http://blog.csdn.net/oqqYeYi/article/details/39831029
     */
    @Test
    public void testResize(){
        int realCount = 2048;
        int tableSize = getHashMapInitCount(realCount);
        System.out.println("tableSize = " + tableSize);
    }

    /**
     * 根据需要放入HashMap的实际数量,获取初始值size
     * @param realCount
     * @return
     */
    private int getHashMapInitCount(int realCount) {
        int tableSize = tableSizeFor(realCount);

        while (realCount > tableSize * 0.75) {
            tableSize = tableSize * 2;
        }
        return tableSize;
    }


    /**
     * 根据hashCode找数组中的位置,然后根据equals在链表中循环判断具体是哪个key
     */
    @Test
    public void testHashCodeAndEquals(){

    }

    /**
     * 因为length=2^n对应的二进制中只有一个位为1，如果直接计算h & length，那么只能得到两种结果（2^n或0），
     * 而length-1=2^n-1对应的二进制中末尾有n个位都是1。
     * 计算h &( length-1)其实等价于计算h%length，本质就是截取h的后n个二进制位，
     * 目的是将我们put进来的元素的key映射到HashMap底层数组对应的hash桶中，
     * 这里采用与运算比模运算的开销小得多，
     * 由于indexFor函数经常要使用，所以为了效率HashMap要求底层数组的length总是2的幂，这样就能用与运算代替模运算了。这才是h & (length-1)的玄机。
     * @see TestBit3
     */
    @Test
    public void testHash(){

    }
}
