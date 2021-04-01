package com.javaapi.test.util.log.compare.diff;


import com.alibaba.fastjson.JSON;
import com.javaapi.test.util.log.compare.diff.annotation.LogCompare;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 日志工具类
 */
public class OperatorLogUtils {


    private static Logger logger = LoggerFactory.getLogger(OperatorLogUtils.class);

    /**
     * 比较两个相同类型对象的字段修改
     *
     * @param oldObj 修改前实体
     * @param newObj 修改后实体
     * @param <T>    泛型类型
     * @return 修改的字段明细
     */
    public static <T> String diff(T oldObj, T newObj) {
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> clazz = oldObj.getClass();
            LogCompare classLog = clazz.getAnnotation(LogCompare.class);
            sb.append(classLog.name());

            Field[] fields = getAllFields(clazz);
            for (Field field : fields) {
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                LogCompare fieldLog = field.getAnnotation(LogCompare.class);
                if (fieldLog == null) {
                    continue;
                }

                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object oldValue = getMethod.invoke(oldObj);
                Object newValue = getMethod.invoke(newObj);
                //都为null情况
                if (oldValue == newValue) {
                    continue;
                }
                if (null == oldValue) {
                    sb.append(",").append(fieldLog.name()).append(": ").append("null").append(" -> ").append(reflectValue(newValue, fieldLog, field));
                } else if (null == newValue) {
                    sb.append(",").append(fieldLog.name()).append(": ").append(reflectValue(oldValue, fieldLog, field)).append(" -> ").append("null");
                } else if (!StringUtils.equals(oldValue.toString(), newValue.toString())) {
                    if (fieldLog.type() == LogCompare.Type.STRING) {
                        sb.append(",").append(fieldLog.name()).append(": ").append(oldValue).append(" -> ").append(newValue);
                    } else if (fieldLog.type() == LogCompare.Type.ENUM) {
                        Class<?> enumType = Class.forName(field.getGenericType().getTypeName());
                        Method getDesc = enumType.getMethod("getText");
                        sb.append(",").append(fieldLog.name()).append(": ").append(getDesc.invoke(oldValue)).append(" -> ").append(getDesc.invoke(newValue));
                    } else if (fieldLog.type() == LogCompare.Type.DATE) {
                        sb.append(",").append(fieldLog.name()).append(": ").append(format((Date) oldValue, "yyyy-MM-dd HH:mm:ss")).append(" -> ")
                          .append(format((Date) newValue, "yyyy-MM-dd HH:mm:ss"));
                    } else if (fieldLog.type() == LogCompare.Type.LONG || fieldLog.type() == LogCompare.Type.INTEGER) {
                        sb.append(",").append(fieldLog.name()).append(": ").append(String.valueOf(oldValue)).append(" -> ").append(String.valueOf(newValue));
                    }
                }
            }
            String compare = sb.toString();
            return StringUtils.equals(classLog.name(), compare) ? null : compare;
        } catch (Exception e) {
            logger.error("记录修改明细异常,oldObj:" + JSON.toJSONString(oldObj) + ",newObj:" + JSON.toJSONString(newObj), e);
        }
        return "获取修改明细异常";
    }

    private static String reflectValue(Object value, LogCompare fieldLog, Field field) throws Exception {
        if (fieldLog.type() == LogCompare.Type.STRING) {
            return value.toString();
        } else if (fieldLog.type() == LogCompare.Type.ENUM) {
            Class<?> enumType = Class.forName(field.getGenericType().getTypeName());
            Method getDesc = enumType.getMethod("getText");
            return getDesc.invoke(value).toString();
        } else if (fieldLog.type() == LogCompare.Type.DATE) {
            return format((Date) value, "yyyy-MM-dd HH:mm:ss");
        } else if (fieldLog.type() == LogCompare.Type.LONG) {
            return String.valueOf(value);
        } else if (fieldLog.type() == LogCompare.Type.INTEGER) {
            return String.valueOf(value);
        }
        throw new Exception("不支持的字段类型");
    }

    /**
     * 获取子类及其父类所有属性
     *
     * @param clazz Class
     * @return Field[]
     */
    private static Field[] getAllFields(Class clazz) {
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }

    public static String format(Date date, String format) {
        return date == null ? null : (new SimpleDateFormat(format)).format(date);
    }

}
