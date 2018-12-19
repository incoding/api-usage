package com.javaapi.test.test.type.String.testString.toolString;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import org.junit.Test;

/**
 * http://kgd1120.iteye.com/blog/1293633
 *
 */
public class StringFormat {
	/**
	 * 字符串格式化 ,@see {@link Formatter}
	 */
	@Test
	public void test() {
		String str = null;
		str = String.format("Hi,%s%n", "飞龙"); // 格式化字符串
		System.out.println(str); // 输出字符串变量str的内容
		str = String.format("Hi,%s", "飞龙"); // 格式化字符串
		System.out.println(str); // 输出字符串变量str的内容
//		System.out.printf("字母a的大写是：%c %n", 'A');
//		System.out.printf("3>7的结果是：%b %n", 3 > 7);
//		System.out.printf("100的一半是：%d %n", 100 / 2);
//		System.out.printf("100的16进制数是：%x %n", 100);
//		System.out.printf("100的8进制数是：%o %n", 100);
//		System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
//		System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
//		System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
//		System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50 * 0.85);
//		System.out.printf("上面的折扣是%d%% %n", 85);
//		System.out.printf("字母A的散列码是：%h %n", 'A');
	}
	   
    @Test
    public void testSimpleDateFormat(){
        SimpleDateFormat sf = new SimpleDateFormat("E");
        String format = sf.format(new Date());
        System.out.println(format);
        
    }
    @Test
    public void testEqual(){
        String string = "*";
        if("*".equals(string)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        
    }
    @Test
    public void testValueOf(){
        int i  =1 ;
        System.out.println(String.valueOf(i));
    }
	 /**
     * 
     * http://blog.csdn.net/lonely_fireworks/article/details/7962171
     */
    @Test
    public void testStringFormat() {
        String format = String.format("%s:", "nihao");
        System.out.println(format);
    }

    @Test
    public void testStringFormat2() {
        String msg = String.format("航站楼缺失,出发,到达,起飞时间,携程id=[%,%,%,%]", "1", null, "2", "3");
        System.out.println(msg);
    }


    @Test
    public void testStringFormatPerfm() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
//            String format = String.format("%s:", "nihao");
            String format = String.format("%s:%s:%s:%s:%s:", "nihao", "nihao", "nihao", "nihao", "nihao");
        }
        long end =System.currentTimeMillis();
        System.out.println("done"+((end-start)));
    }
    @Test
    public void testMessageFormat() {
        String format = MessageFormat.format("nihao:{0},{1},{2},{3},{4}", "1", "1", "1", "1", "1");
        System.out.println(format);
    }
    /**
     * 
     * messageFormat得性能优于stringformat
     */
    @Test
    public void testMessageFormatPerfm() {
        long start = System.currentTimeMillis();
        int j = 100000;
		for (int i = 0; i < j; i++) {
            String format = MessageFormat.format("nihao:{0},{1},{2},{3},{4}", "nihao", "nihao", "nihao", "nihao", "nihao");
        }
        long end =System.currentTimeMillis();
        System.out.println("done"+((end-start)));
    }

}
