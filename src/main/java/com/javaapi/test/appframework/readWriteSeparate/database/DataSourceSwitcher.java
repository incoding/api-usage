package com.javaapi.test.appframework.readWriteSeparate.database;
import org.springframework.util.Assert;

/**
 */
public class DataSourceSwitcher {

    private static final ThreadLocal contextHolder = new ThreadLocal();

    private static final String DATA_SOURCE_SLAVE = "slave" ;

    public static void setDataSource(String dataSource) {
        Assert.notNull(dataSource, "dataSource cannot be null");
        contextHolder.set(dataSource);
    }

    public static void setMaster(){
        clearDataSource();
    }

    public static void setSlave() {
        setDataSource( DATA_SOURCE_SLAVE);
    }

    public static String getDataSource() {
        return (String) contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}