package com.javaapi.test.util.log.stringdesc;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.util.log.stringdesc.annotation.LogDesc;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public class LogConcatUtil {

    private static Logger logger = LoggerFactory.getLogger(LogConcatUtil.class);

    /**
     * 比较两个相同类型对象的字段修改
     *
     * @param oldObj 修改前实体
     * @param <T>    泛型类型
     * @return 修改的字段明细
     */
    public static <T> String desc(T oldObj) {
        StringJoiner sb = new StringJoiner(",");
        try {
            Class<?> clazz = oldObj.getClass();
            Field[] fields = getAllFields(clazz);
            for (Field field : fields) {
                if ("serialVersionUID".equals(field.getName())) {
                    continue;
                }
                LogDesc fieldLog = field.getAnnotation(LogDesc.class);
                if (fieldLog == null) {
                    continue;
                }

                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object oldValue = getMethod.invoke(oldObj);
                //都为null情况
                if (oldValue == null) {
                    continue;
                }
                String str = reflectValue(oldValue, fieldLog, field);
                if (StringUtils.isBlank(str)) {
                    continue;
                }
                sb.add(String.format("%s:%s", fieldLog.name(), str));
            }
            String compare = sb.toString();
            return compare;
        } catch (Exception e) {
            logger.error("日志异常,oldObj:" + JSON.toJSONString(oldObj));
        }
        return "获取修改明细异常";
    }

    private static String reflectValue(Object value, LogDesc fieldLog, Field field) throws Exception {
        if (fieldLog.type() == LogDesc.Type.STRING) {
            return value.toString();
        } else if (fieldLog.type() == LogDesc.Type.ENUM) {
            Class<?> enumType = Class.forName(field.getGenericType().getTypeName());
            Method getDesc = enumType.getMethod("getText");
            return getDesc.invoke(value).toString();
        } else if (fieldLog.type() == LogDesc.Type.DATE) {
            return DateFormatUtils.format((Date) value, "yyyy-MM-dd HH:mm:ss");
        } else if (fieldLog.type() == LogDesc.Type.LONG) {
            return String.valueOf(value);
        } else if (fieldLog.type() == LogDesc.Type.INTEGER) {
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
}
