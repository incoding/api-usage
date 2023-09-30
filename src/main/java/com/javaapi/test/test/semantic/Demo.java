package com.javaapi.test.test.semantic;


import java.util.Arrays;
import java.util.List;

/**
 * 测试入口
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        String data = "( ( 1 + pow(2,4) ) >= 12 )& ( true | ( 3 > count($a) ) ) ";
        Decompose current = new Decompose();
        List<Decompose.DataTypeStructure> dataTypeStructures = current.paramCut(data);
        dataTypeStructures.stream().forEach(f-> System.out.println(f));
        StackCalc stackCalc = new StackCalc();
        stackCalc.setKV("a", Arrays.asList(new Double[]{1D, 2D, 3D}));//设置引用变量,表达式可以使用$a获取这个数值
        Object result = stackCalc.stackCalc(dataTypeStructures);//弹栈计算
        System.out.println("计算结果为:" + result);
    }
}