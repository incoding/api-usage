package com.javaapi.test.test.type.integer;

import org.junit.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.List;

public class TestInteger {

    /**
     * 1 都是对象,用==肯定不会相等
     * 2 基本类型转换成包装类型是调用valueof实现的(-127 到128 会返回相同的Integer对象)(其他为不同Integer对象)
     */
    @Test
    public void testInteger() {
        Integer aInteger = new Integer(10);
        Integer bInteger = new Integer(10);
        System.out.println(aInteger == bInteger);
        aInteger = 10;
        bInteger = 10;
        System.out.println(aInteger == bInteger);
        aInteger = Integer.valueOf(10);
        bInteger = Integer.valueOf(10);
        System.out.println(aInteger == bInteger);
        System.out.println("============");
        Integer abig = new Integer(129);
        Integer bbig = new Integer(129);
        System.out.println(abig == bbig);
        abig = 129;
        bbig = 129;
        System.out.println(abig == bbig);
        Integer a = Integer.valueOf(129);
        Integer b = Integer.valueOf(129);
        System.out.println(a == b);
    }

    @Test
    public void testIntegerGtOrLT() {
        Integer aInteger = new Integer(1);
        Integer bInteger = new Integer(1);
        System.out.println(aInteger == bInteger);
        System.out.println(aInteger.compareTo(bInteger));
        System.out.println(aInteger.equals(bInteger));
        System.out.println(aInteger.equals(1));
        // int 赋值给对象就变为Integer对象
        Object a = 128;
        System.out.println(a instanceof Integer);
    }

    @Test
    public void testInteger127() {
        Integer aInteger = 127;
        Integer bInteger = 127;
        System.out.println(aInteger == bInteger);
    }

    @Test
    public void testInteger128() {
        Integer aInteger = 128;
        Integer bInteger = 128;
        System.out.println(aInteger == bInteger);
    }

    /**
     * 自动装箱是靠 Integer.valueOf()来实现,Integer.valueOf 之后是Integer对象,</br>
     * http://blog.csdn.net/ma451152002/article/details/9076793
     */
    @Test
    public void testInteger2() {
        int value = 10;
        Integer aInteger = value;
        Integer bInteger = value;
        System.out.println(aInteger == bInteger);
        System.out.println("---------------");
        Integer aValue = Integer.valueOf(value);
        Integer bValue = Integer.valueOf(value);
        System.out.println(aValue == bValue);
        System.out.println("---------------");


        int value2 = 129;
        Integer abig = value2;
        Integer bbig = value2;
        System.out.println(abig == bbig);
        System.out.println("---------------");
        Integer a = Integer.valueOf(value2);
        Integer b = Integer.valueOf(value2);
        System.out.println(a == b);
        System.out.println("---------------");
    }

    /**
     * 因为在对a操作时(a=a+1或者a++)，a重新创建了一个对象，而b对应的还是缓存里的100，所以输出的结果为false
     */
    @Test
    public void testInteger3() {
        Integer a = 100;
        Integer b = a;
        a = a + 1; // 或者a++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
    }

    @Test
    public void testIntegerNull() throws Exception {
        Integer a = 1;
        System.out.println("a = " + a==null?true:false);


    }

    @Test
    public void testIntegerNul2() throws Exception {
        Integer a = null;
        if (a != 0) {
            System.out.println("a = " + a);
        }


    }

    /**
     * 测试 integer输出string
     */
    @Test
    public void test4(){
        Integer a = 1;
        System.out.println("a = " + a.toString());
    }

    /**
     * Integer 传递到参数,要进行包装才能累加
     */
    @Test
    public void test(){
        final Integer[] a = {1};
        final Integer[] b = {0};
        List<Integer> integers = Lists.newArrayList(1, 3, 3, 1, 3, 4, 5, 7, 2);
        integers.forEach(integer -> {
            a[0] += 1;
            integers.forEach(integer1 -> {
                b[0] += 1;
            });
        });
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
    }

    @Test
    public void testModule(){
        for (int j = 0; j <= 1000; j++) {
            int module = getModule(j);
            if (module == 0) {
                System.out.println("module = " + j);
            }
        }


    }

    private int getModule(int a) {
        return a % 100;
    }


    /**
     * 直接valueOf是会报错的
     */
    @Test
    public void testValueOf(){
        Integer integer = Integer.valueOf("22.5");
        System.out.println("integer = " + integer);

    }
}
