package com.javaapi.test.test.semantic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 常量
 */
public class Const {
    public static String empty = " ";//空字符

    /**
     * 计算符号
     */
    public static class CalcSymbol {
        public final static String greater = ">";//大于
        public final static String less = "<";//小于
        public final static String equal = "==";//等于
        public final static String greaterEqual = ">=";//大于等于
        public final static String lessEqual = "<=";//小于等于
        public final static String notEqual = "!=";//不等于
        public final static String add = "+";
        public final static String minus = "-";
        public final static String multi = "*";
        public final static String divide = "/";
        public final static String and = "&";
        public final static String or = "|";
        public final static String remainder = "%";
        public final static String pow = "^";
        public final static String comma = ",";
        public final static Set<String> calcSymbolSet = new HashSet<>(Arrays.asList(new String[]{",", ">", "<", "=", "!", "+", "-", "*", "/", "|", "&", "%", "^"}));
    }

    /**
     * 计算优先级
     * 计算优先级集合,级别数字越小,越优先计算
     */
    public static class CalcLevel {
        //1级
        public final static Set<String> calcLevelOne = new HashSet<>(Arrays.asList(new String[]{"*", "/"}));
        //2级
        public final static Set<String> calcLevelTwo = new HashSet<>(Arrays.asList(new String[]{">", "<", "=", "!", "+", "-", "|", "&", "%", "^"}));
        //3级
        public final static Set<String> calcLevelThree = new HashSet<>(Arrays.asList(new String[]{","}));
    }

    /**
     * 括号
     */
    public static class Bracket {
        public static final String leftBracket = "(";
        public static final String rightBracket = ")";
        public static final Set<String> bracketSymbolSet = new HashSet<>(Arrays.asList(new String[]{"(", ")"}));
    }

    /**
     * 自定义函数
     */
    public static class Func {
        public static final String pow = "pow";//pow(2,4) 2^4 = 16
        public static final String count = "count";//count([1,2,1,2,1]) = 5
    }
}