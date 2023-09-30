package com.javaapi.test.test.semantic;


import java.util.*;
import java.util.regex.Pattern;

/**
 * 自定义函数与基本数据计算的实现代码
 */
public class LogicalCalc {

    /**
     * 基本数据计算
     */
    public static class MathCalc {

        /**
         * 分支计算
         *
         * @param symbol 分割符号
         * @param one    变量1
         * @param two    变量2
         * @return
         * @throws Exception
         */
        public static Object exec(String symbol, Object one, Object two) throws Exception {
            Object result;
            switch (symbol) {
                case Const.CalcSymbol.comma:
                    result = MathCalc.comma(one, two);
                    break;
                case Const.CalcSymbol.add:
                    result = MathCalc.add(one, two);
                    break;
                case Const.CalcSymbol.minus:
                    result = MathCalc.minus(one, two);
                    break;
                case Const.CalcSymbol.multi:
                    result = MathCalc.multi(one, two);
                    break;
                case Const.CalcSymbol.divide:
                    result = MathCalc.divide(one, two);
                    break;
                case Const.CalcSymbol.pow:
                    result = MathCalc.pow(one, two);
                    break;
                case Const.CalcSymbol.remainder:
                    result = MathCalc.remainder(one, two);
                    break;
                case Const.CalcSymbol.and:
                    result = MathCalc.and(one, two);
                    break;
                case Const.CalcSymbol.or:
                    result = MathCalc.or(one, two);
                    break;
                case Const.CalcSymbol.greater:
                    result = MathCalc.greater(one, two);
                    break;
                case Const.CalcSymbol.less:
                    result = MathCalc.less(one, two);
                    break;
                case Const.CalcSymbol.equal:
                    result = MathCalc.equal(one, two);
                    break;
                case Const.CalcSymbol.greaterEqual:
                    result = MathCalc.greaterEqual(one, two);
                    break;
                case Const.CalcSymbol.lessEqual:
                    result = MathCalc.lessEqual(one, two);
                    break;
                case Const.CalcSymbol.notEqual:
                    result = MathCalc.notEqual(one, two);
                    break;
                default:
                    throw new Exception(String.format("计算符号%s未实现", symbol));
            }
            System.out.println("计算" + one + " " + symbol + " " + two + " = " + result);
            return result;
        }

        /**
         * 字符串拼接
         *
         * @param one
         * @param two
         * @return
         */
        private static Object comma(Object one, Object two) {
            if (two instanceof LinkedList) {
                LinkedList index = (LinkedList) two;
                if (index.size() > 2) {
                    index.addFirst(one);
                    return index;
                }
            }
            LinkedList<Object> index = new LinkedList<>(Arrays.asList(new Object[]{one, two}));
            return index;
        }


        /**
         * 计算二者的和
         *
         * @param one
         * @param two
         * @return
         */
        public static Double add(Object one, Object two) {
            Double oneDouble = Double.valueOf(String.valueOf(one));
            Double twoDouble = Double.valueOf(String.valueOf(two));
            return oneDouble + twoDouble;
        }

        /**
         * 计算二者的差
         *
         * @param one
         * @param two
         * @return
         */
        public static Double minus(Object one, Object two) {
            Double oneDouble = Double.valueOf(String.valueOf(one));
            Double twoDouble = Double.valueOf(String.valueOf(two));
            return oneDouble - twoDouble;
        }


        /**
         * 计算二者的积
         *
         * @param one
         * @param two
         * @return
         */
        public static Double multi(Object one, Object two) {
            Double oneDouble = Double.valueOf(String.valueOf(one));
            Double twoDouble = Double.valueOf(String.valueOf(two));
            return oneDouble * twoDouble;
        }

        /**
         * 计算二者的商
         *
         * @param one
         * @param two
         * @return
         */
        public static Double divide(Object one, Object two) {
            Double oneDouble = Double.valueOf(String.valueOf(one));
            Double twoDouble = Double.valueOf(String.valueOf(two));
            return oneDouble / twoDouble;
        }

        /**
         * n次方计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object pow(Object one, Object two) {
            Double oneDouble = Double.valueOf(String.valueOf(one));
            Double twoDouble = Double.valueOf(String.valueOf(two));
            return Math.pow(oneDouble, twoDouble);
        }

        /**
         * 取余计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object remainder(Object one, Object two) {
            Double oneDouble = Double.valueOf(String.valueOf(one));
            Double twoDouble = Double.valueOf(String.valueOf(two));
            return oneDouble % twoDouble;
        }


        /**
         * 与计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object and(Object one, Object two) {
            return ("true".equals(String.valueOf(one)) && "true".equals(String.valueOf(two))) ? true : false;
        }

        /**
         * 或计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object or(Object one, Object two) {
            return ("true".equals(String.valueOf(one)) || "true".equals(String.valueOf(two))) ? true : false;
        }

        /**
         * 大于计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object greater(Object one, Object two) {
            if (Util.isNumber(one) && Util.isNumber(two)) {
                return Double.valueOf(String.valueOf(one)) > Double.valueOf(String.valueOf(two));
            } else {
                return String.valueOf(one).compareTo(String.valueOf(two)) > 0;
            }
        }

        /**
         * 小于计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object less(Object one, Object two) {
            if (Util.isNumber(one) && Util.isNumber(two)) {
                return Double.valueOf(String.valueOf(one)) < Double.valueOf(String.valueOf(two));
            } else {
                return String.valueOf(one).compareTo(String.valueOf(two)) < 0;
            }
        }

        /**
         * 等于计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object equal(Object one, Object two) {
            if (Util.isNumber(one) && Util.isNumber(two)) {
                return Double.valueOf(String.valueOf(one)) == Double.valueOf(String.valueOf(two));
            } else {
                return String.valueOf(one).compareTo(String.valueOf(two)) == 0;
            }
        }

        /**
         * 大于等于计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object greaterEqual(Object one, Object two) {
            if (Util.isNumber(one) && Util.isNumber(two)) {
                return Double.valueOf(String.valueOf(one)) >= Double.valueOf(String.valueOf(two));
            } else {
                return String.valueOf(one).compareTo(String.valueOf(two)) >= 0;
            }
        }

        /**
         * 小于等于计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object lessEqual(Object one, Object two) {
            if (Util.isNumber(one) && Util.isNumber(two)) {
                return Double.valueOf(String.valueOf(one)) <= Double.valueOf(String.valueOf(two));
            } else {
                return String.valueOf(one).compareTo(String.valueOf(two)) <= 0;
            }
        }

        /**
         * 不等于计算
         *
         * @param one
         * @param two
         * @return
         */
        private static Object notEqual(Object one, Object two) {
            if (Util.isNumber(one) && Util.isNumber(two)) {
                return Double.valueOf(String.valueOf(one)) != Double.valueOf(String.valueOf(two));
            } else {
                return String.valueOf(one).compareTo(String.valueOf(two)) != 0;
            }
        }
    }


    /**
     * 函数计算
     */
    public static class FuncCalc {

        /**
         * @param func  函数名称
         * @param param 函数参数,多个参数的组合为链表
         * @return
         * @throws Exception
         */
        public static Object exec(String func, Object param) throws Exception {
            Object result;
            switch (func) {
                case Const.Func.pow:
                    result = pow(param);
                    break;
                case Const.Func.count:
                    result = count(param);
                    break;
                default:
                    throw new Exception(String.format("自定义方法%s未实现", func));
            }
            System.out.println("计算自定义方法:" + func + "(" + param + ") = " + result);
            return result;
        }


        /**
         * 次方计算
         *
         * @param param
         * @return
         * @throws Exception
         */
        public static Object pow(Object param) throws Exception {
            LinkedList index = (LinkedList) param;
            if (index.size() != 2) {
                throw new Exception(String.format("方法参数数量异常,pow(a,b) -> pow(%s)", index));
            }
            Object one = index.getFirst();
            Object two = index.getLast();
            Double oneDouble = Double.valueOf(String.valueOf(one));
            Double twoDouble = Double.valueOf(String.valueOf(two));
            return Math.pow(oneDouble, twoDouble);
        }

        /**
         * 统计集合长度
         *
         * @param param
         * @return
         */
        private static Object count(Object param) {
            if (param instanceof Collection) {
                return ((Collection) param).size();
            }
            if (param == null) {
                return 0;
            }
            return 1;
        }
    }


    /**
     * 内部工具类
     */
    private static class Util {
        private final static String pattern = "^[0-9]+(\\.[0-9]+)?(E\\-?[0-9]+)?$";//转化为double的数值计算

        /**
         * 是否是数字
         *
         * @param str
         * @return
         */
        public static boolean isNumber(Object str) {
            return Pattern.matches(pattern, String.valueOf(str));
        }
    }
}