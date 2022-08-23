package com.javaapi.test.test.misc.sql;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

public class Client {

    @Test
    public void test(){
        String s = insertPersonSql();
        System.out.println("s = " + s);
    }

    public String insertPersonSql() {
        String sql = new SQL()
                .INSERT_INTO("PERSON")
                .VALUES("ID, FIRST_NAME", "#{id}, #{firstName}")
                .VALUES("LAST_NAME", "#{lastName}")
                .toString();
        return sql;
    }


    @Test
    public void test2(){
    }


}
