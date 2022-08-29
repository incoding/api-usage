package com.javaapi.test.spring.spring.pattern.templatev2.factory.util;

import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import java.util.Map;

public class LogContextUtils {
    public static final String MODULE = "LOGGER_MODULE";
    public static final String PREFIX_MODULE = "XX_";
    public static final String CATEGORY = "LOGGER_CATEGORY";
    public static final String SUBCATEGORY = "LOGGER_SUBCATEGORY";
    public static final String TRACE_ID = "TRACE_ID";
    private static String FILTER1 = "LOGGER_FILTER1";
    private static String FILTER2 = "LOGGER_FILTER2";
    private static String BIZ_DATA_ID = "BIZ_DATA_ID";
    private static String PREVIOUS_BIZ_DOMAIN = "PREVIOUS_BIZ_DOMAIN";
    private static String PREVIOUS_BIZ_DATA_ID = "PREVIOUS_BIZ_DATA_ID";
    private static ThreadLocal<Map<String, String>> extraInfo = new ThreadLocal();

    public LogContextUtils() {
    }

    public static void initTracer(String module, String traceId, String serialNo) {
        setData(traceId, module, (String) null, (String) null, serialNo, (String) null, (String) null, traceId, serialNo);
    }

    public static void setData(String traceId, String module, String category, String subCategory, String bizDataId, String previousBizDomain, String previousBizDataId, String filter1, String filter2) {
        setTraceId(traceId);
        setModule(module);
        setCategory(category);
        setSubCategory(subCategory);
        setBizDataId(bizDataId);
        setPreviousBizDomain(previousBizDomain);
        setPreviousBizDataId(previousBizDataId);
        setFilter1(filter1);
        setFilter2(filter2);
    }

    public static void setData(String traceId, String module, String category, String subCategory, String bizDataId, String previousBizDomain, String previousBizDataId) {
        setTraceId(traceId);
        setModule(module);
        setCategory(category);
        setSubCategory(subCategory);
        setBizDataId(bizDataId);
        setPreviousBizDomain(previousBizDomain);
        setPreviousBizDataId(previousBizDataId);
    }

    public static void setData(String traceId, String module, String bizDataId, String previousBizDomain, String previousBizDataId) {
        setTraceId(traceId);
        setModule(module);
        setBizDataId(bizDataId);
        setPreviousBizDomain(previousBizDomain);
        setPreviousBizDataId(previousBizDataId);
    }

    public static void setData(String traceId, String module, String bizDataId) {
        setTraceId(traceId);
        setModule(module);
        setBizDataId(bizDataId);
    }

    public static void setTraceId(String traceId) {
        if (StringUtils.isBlank(traceId)) {
            MDC.remove("TRACE_ID");
        } else {
            MDC.put("TRACE_ID", traceId);
        }
    }

    public static void removeTraceId() {
        MDC.remove("TRACE_ID");
    }

    public static String getTraceId() {
        return MDC.get("TRACE_ID");
    }

    public static void setMarker(String module, String category, String subCategory) {
        setModule(module);
        setCategory(category);
        setSubCategory(subCategory);
    }

    public static void setMarker(String module, String category) {
        setModule(module);
        setCategory(category);
    }

    public static void setModule(String module) {
        if (StringUtils.isNotBlank(module) && !StringUtils.equals("null", module)) {
            if (StringUtils.startsWith(module, "BUS_")) {
                MDC.put("LOGGER_MODULE", module);
            } else {
                MDC.put("LOGGER_MODULE", "BUS_" + module);
            }
        } else {
            removeModule();
        }

    }

    public static void removeModule() {
        MDC.remove("LOGGER_MODULE");
    }

    public static String getModule() {
        return MDC.get("LOGGER_MODULE");
    }

    public static String getCategory() {
        return MDC.get("LOGGER_CATEGORY");
    }

    public static void setCategory(String category) {
        if (StringUtils.isBlank(category)) {
            MDC.remove("LOGGER_CATEGORY");
        } else {
            MDC.put("LOGGER_CATEGORY", category);
        }
    }

    public static void removeCategory() {
        MDC.remove("LOGGER_CATEGORY");
    }

    public static String getSubCategory() {
        return MDC.get("LOGGER_SUBCATEGORY");
    }

    public static void setSubCategory(String subCategory) {
        if (StringUtils.isBlank(subCategory)) {
            MDC.remove("LOGGER_SUBCATEGORY");
        } else {
            MDC.put("LOGGER_SUBCATEGORY", subCategory);
        }
    }

    public static void removeSubCategory() {
        MDC.remove("LOGGER_SUBCATEGORY");
    }

    public static String getFilter1() {
        return MDC.get(FILTER1);
    }

    public static void setFilter1(String filter1) {
        if (StringUtils.isBlank(filter1)) {
            MDC.remove(FILTER1);
        } else {
            MDC.put(FILTER1, filter1);
        }
    }

    public static void removeFilter1() {
        MDC.remove(FILTER1);
    }

    public static String getFilter2() {
        return MDC.get(FILTER2);
    }

    public static void setFilter2(String filter2) {
        if (StringUtils.isBlank(filter2)) {
            MDC.remove(FILTER2);
        } else {
            MDC.put(FILTER2, filter2);
        }
    }

    public static void removeFilter2() {
        MDC.remove(FILTER2);
    }

    public static void removeAll() {
        removeModule();
        removeCategory();
        removeSubCategory();
        removeFilter1();
        removeFilter2();
        removeTraceId();
        removePreviousBizDomain();
        removeBizDataId();
        removePreviousBizDataId();
    }

    public static void setBizDataId(String bizDataId) {
        if (StringUtils.isBlank(bizDataId)) {
            MDC.remove(BIZ_DATA_ID);
        } else {
            MDC.put(BIZ_DATA_ID, bizDataId);
        }
    }

    public static void removeBizDataId() {
        MDC.remove(BIZ_DATA_ID);
    }

    public static String getBizDataId() {
        return MDC.get(BIZ_DATA_ID);
    }

    public static void setPreviousBizDomain(String previousBizDomain) {
        if (StringUtils.isBlank(previousBizDomain)) {
            MDC.remove(PREVIOUS_BIZ_DOMAIN);
        } else {
            MDC.put(PREVIOUS_BIZ_DOMAIN, previousBizDomain);
        }
    }

    public static void removePreviousBizDomain() {
        MDC.remove(PREVIOUS_BIZ_DOMAIN);
    }

    public static String getPreviousBizDomain() {
        return MDC.get(PREVIOUS_BIZ_DOMAIN);
    }

    public static void setPreviousBizDataId(String previousBizDataId) {
        if (StringUtils.isBlank(previousBizDataId)) {
            MDC.remove(PREVIOUS_BIZ_DATA_ID);
        } else {
            MDC.put(PREVIOUS_BIZ_DATA_ID, previousBizDataId);
        }
    }

    public static void removePreviousBizDataId() {
        MDC.remove(PREVIOUS_BIZ_DATA_ID);
    }

    public static String getPreviousBizDataId() {
        return MDC.get(PREVIOUS_BIZ_DATA_ID);
    }

    public static String formatMsg(String format, Object... obj) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, obj);
        return ft.getMessage();
    }

    public static void filterCloseableLog(FilterCloseableFunction function) {
        String filter1 = getFilter1();
        String filter2 = getFilter2();
        function.exec();
        setFilter1(filter1);
        setFilter2(filter2);
    }

    public static void filterCloseableLog(String filter1, String filter2, FilterCloseableFunction function) {
        String srcfilter1 = getFilter1();
        String srcfilter2 = getFilter2();
        setFilter1(filter1);
        setFilter2(filter2);
        function.exec();
        setFilter1(srcfilter1);
        setFilter2(srcfilter2);
    }

    public static void info(Logger logger, String filter1, String filter2, String format, Object... args) {
        filterCloseableLog(filter1, filter2, () -> {
            logger.info(format, args);
        });
    }

    public static void warn(Logger logger, String filter1, String filter2, String format, Object... args) {
        filterCloseableLog(filter1, filter2, () -> {
            logger.warn(format, args);
        });
    }

    public static void error(Logger logger, String filter1, String filter2, Throwable t, String format, Object... args) {
        FormattingTuple ft = MessageFormatter.arrayFormat(format, args);
        filterCloseableLog(filter1, filter2, () -> {
            logger.error(ft.getMessage(), t);
        });
    }

    public static Map<String, String> getExtraInfo() {
        Map<String, String> result = (Map) extraInfo.get();
        if (MapUtils.isEmpty((Map) result)) {
            result = Maps.newHashMap();
        }

        return (Map) result;
    }

    public static void infoCloseableLog(Map<String, String> extraInfo, FilterCloseableFunction function) {
        LogContextUtils.extraInfo.set(extraInfo);
        filterCloseableLog(function);
        LogContextUtils.extraInfo.remove();
    }

    @FunctionalInterface
    public interface FilterCloseableFunction {
        void exec();
    }
}
