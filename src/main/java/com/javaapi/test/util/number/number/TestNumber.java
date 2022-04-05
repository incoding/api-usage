package com.javaapi.test.util.number.number;

import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestNumber {

    /**
     * 
     * @create_time 2014年12月1日 上午10:00:09 
     */
    @Test
    public void testMax() {
        /*4. NumberUtils.max() :找出最大的一个*/

        NumberUtils.max(new int[] { 3, 5, 6 });//结果是6
        NumberUtils.max(3, 1, 7);//结果是7

        /*5. NumberUtils.min() :找出最小的一个*/

        NumberUtils.min(new int[] { 3, 5, 6 });//结果是6
        NumberUtils.min(3, 1, 7);//结果是7
    }

    /**
     * 
     * @create_time 2014年12月1日 上午9:59:59 
     */
    @Test
    public void testToInt() {
        /*3. NumberUtils.toInt() :字符串转换为数字*/

        NumberUtils.toInt("5");
        NumberUtils.toLong("5");
        NumberUtils.toFloat("");
        NumberUtils.toDouble("4");
    }

    /**
     * 
     * @create_time 2014年12月1日 上午9:59:00 
     */
    @Test
    public void testIsDigit() {
        /*2. NumberUtils.isDigits() :判断字符串中是否全为数字*/
        boolean digits = NumberUtils.isDigits("0.596");//false
        boolean digits2 = NumberUtils.isDigits("0000000000596");//true
        System.out.println(digits);
        System.out.println(digits2);
    }

    /**
     * 
     * @create_time 2014年12月1日 上午9:58:46 
     */
    @Test
    public void testIsNumber() {
        /*1. NumberUtils.isNumber() : 判断字符串是否是数字*/

        NumberUtils.isNumber("5.96");//结果是true
        NumberUtils.isNumber("s5");//结果是false
        NumberUtils.isNumber("0000000000596");//结果是true
    }

    @Test
    public void testFloatToInt() throws Exception {
        String s = "1.1";
        Float v = Float.parseFloat(s);
        int i = v.intValue();
        System.out.println("i = " + i);
    }

    @Test
    public void testInt() throws Exception {
        Map<String,Object> map = new HashMap<>();
        Float viewMod = 1.2f;
//        Integer.valueOf(map.get("views")*(viewMod));

    }

    @Test
    public void testInt2() throws Exception {
        String[] subColumnArr = {"0", "1", "2", "50001", "100001"};
        for (String subColumnValue : subColumnArr) {
            Integer value = Integer.parseInt(subColumnValue.toString());
            Integer threshold = 50000 ;
            int position = (value / threshold) + 1;//获得数据的插入位置
            System.out.println("subColumnValue = "+subColumnValue+",position = " + position);
        }


    }
}
