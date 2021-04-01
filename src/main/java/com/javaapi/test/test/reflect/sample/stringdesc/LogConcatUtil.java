package com.javaapi.test.test.reflect.sample.stringdesc;

import com.google.common.collect.Lists;
import com.javaapi.test.test.reflect.sample.stringdesc.annotation.LogDesc;
import com.javaapi.test.test.reflect.sample.stringdesc.vo.PriceLogVO;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class LogConcatUtil {

    public static void main(String[] args) {
        PriceLogVO log = new PriceLogVO();
        log.setResourceType("xxx");
        log.setAdtPrice("111");
        String message = LogConcatUtil.getMessage(log);
        System.out.println("message = " + message);

    }

    private static final Map<String, LogFieldResoler> field2Map = new HashMap<>();

    static {
        ResourceTypeLogFieldResoler resourceTypeLogFieldResoler = new ResourceTypeLogFieldResoler();
        AdtPriceFieldResoler adtPriceFieldResoler = new AdtPriceFieldResoler();
        field2Map.put(resourceTypeLogFieldResoler.catResolverFieldName(), resourceTypeLogFieldResoler);
        field2Map.put(adtPriceFieldResoler.catResolverFieldName(), adtPriceFieldResoler);
    }

    public static String getMessage(PriceLogVO log) {
        if (log == null) {
            return StringUtils.EMPTY;
        }
        List<LogField> list = Lists.newArrayList();
        Class aClass = log.getClass();
        for (Field field : getAllFields(aClass)) {
            if (!field.isAnnotationPresent(LogDesc.class)) {
                continue;
            }
            LogDesc annotation = field.getAnnotation(LogDesc.class);
            list.add(new LogField(annotation.order(), field.getName()));
        }
        List<LogField> resolvers = list.stream().sorted(Comparator.comparingInt(value -> value.getOrder())).collect(Collectors.toList());
        if (resolvers == null) {
            return StringUtils.EMPTY;
        }
        StringJoiner sj = new StringJoiner("");
        for (LogField resolver : resolvers) {
            // resolver 解析字段
            LogFieldResoler logFieldResoler = field2Map.get(resolver.getResolverName());
            if (logFieldResoler == null) {
                continue;
            }
            logFieldResoler.resolve(log, resolver.getResolverName(), sj);
        }
        return sj.toString();
    }

    public static class LogField {
        private int order;
        private String resolverName;

        public LogField(int order, String resolverName) {
            this.order = order;
            this.resolverName = resolverName;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getResolverName() {
            return resolverName;
        }

        public void setResolverName(String resolverName) {
            this.resolverName = resolverName;
        }
    }

    public interface LogFieldResoler {
        String catResolverFieldName();

        void resolve(PriceLogVO vo, String field, StringJoiner sj);
    }

    public static class ResourceTypeLogFieldResoler implements LogFieldResoler {

        @Override
        public String catResolverFieldName() {
            return "resourceType";
        }

        @Override
        public void resolve(PriceLogVO vo, String field, StringJoiner sj) {
            if (StringUtils.isBlank(vo.getResourceType())) {
                return;
            }
            sj.add("资源:");
            sj.add(vo.getResourceType());
            sj.add(",");
        }
    }

    public static class AdtPriceFieldResoler implements LogFieldResoler {

        @Override
        public String catResolverFieldName() {
            return "adtPrice";
        }

        @Override
        public void resolve(PriceLogVO vo, String field, StringJoiner sj) {
            if (StringUtils.isBlank(vo.getAdtPrice())) {
                return;
            }
            sj.add("价格:");
            sj.add(vo.getAdtPrice());
            sj.add(",");
        }
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
