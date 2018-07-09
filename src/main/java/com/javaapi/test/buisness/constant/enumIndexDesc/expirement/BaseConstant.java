package com.javaapi.test.buisness.constant.enumIndexDesc.expirement;

import com.javaapi.test.buisness.constant.enumIndexDesc.CashTradeIn_task;
import com.javaapi.test.buisness.constant.enumIndexDesc.EnumUtils;

import java.util.List;

/**
 * Created by user on 16/2/28.
 */
public    class BaseConstant<T> {
    public static  Class getEntityClass() {
        return null;
    }

    public static <T> T getByIndex(Integer key) {
        T result = (T) EnumUtils.getEnum(getEntityClass(), key);
        return result;
    }
    public static CashTradeIn_task getByDesc(String desc) {
        CashTradeIn_task result= EnumUtils.getEnum(CashTradeIn_task.class, desc);
        return result;
    }
    public static List<CashTradeIn_task> getAllType() {
        List<CashTradeIn_task> allType = EnumUtils.getAllType(CashTradeIn_task.class);
        return allType;
    }
}
