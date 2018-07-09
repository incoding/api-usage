package com.javaapi.test.buisness.constant.enumIndexDesc;

import java.util.ArrayList;
import java.util.List;

public class EnumUtils {

    /**
     * 根据一个索引得到某个枚举类的枚举值
     * @param <I>
     * @param type
     * 枚举类的Class
     * @param index
     * 索引
     * @return
     * @throws AssertionError
     * 若提供的索引在枚举中没有对映的映射,抛出此断言错误
     */
    public static <I extends IndexIntDesc> I getEnum(Class<I> type, int index) {
        I[] types = type.getEnumConstants();
        for (I t : types) {
            if (t.getIndex() == index) {
                return t;
            }
        }
        throw new AssertionError("不能够映射:" + index + "到枚举" + type.getSimpleName());
    }

    /**
     * 根据一个枚举描述得到某个枚举类的枚举值
     * @param <I>
     * @param type
     *  枚举类的Class
     * @param description
     *  枚举描述
     * @return
     * @throws AssertionError
     * 若提供的枚举描述在枚举中没有对映的映射,抛出此断言错误
     */
    public static <I extends IndexIntDesc> I getEnum(Class<I> type, String description) {
        I[] types = type.getEnumConstants();
        for (I t : types) {
            if (t.getDesc().equals(description)) {
                return t;
            }
        }
        throw new AssertionError("不能够映射:" + description + "到枚举" + type.getSimpleName());
    }
 /**得到所有的索引值,即这里的枚举值
     * @param <I>
     * @param type
     * @return
     */
    public static <I extends IndexIntDesc> List<Integer> getAllIndex(Class<I> type) {
        I[] types = type.getEnumConstants();
        List<Integer> result = new ArrayList<Integer>();
        for (I t : types) {
            result.add(t.getIndex());
        }
        return result;
    }
    /**
     * 得到某枚举类中所有的值的描述
     * @param <I>
     * @param type
     * 枚举类的Class
     * @return
     */
    public static <I extends IndexIntDesc> List<String> getDescriptions(Class<I> type) {
        I[] types = type.getEnumConstants();
        List<String> result = new ArrayList<String>();
        for (I t : types) {
            result.add(t.getDesc());
        }
        return result;
    }
    public static <I extends IndexIntDesc> List<I> getAllType(Class<I> type) {
        I[] types = type.getEnumConstants();
        List<I> result = new ArrayList<I>();
        for (I t : types) {
            result.add(t);
        }
        return result;
    }
}