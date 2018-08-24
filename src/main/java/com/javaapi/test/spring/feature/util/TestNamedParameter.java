package com.javaapi.test.spring.feature.util;

import org.junit.Test;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 15/8/27.
 */
public class TestNamedParameter {
    @Test
    public void test(){
        String sql = "SELECT * FROM abc WHERE a = :a AND b=:b";
        Map<String,String> map = new HashMap<>();
        map.put("b", "2222");
        map.put("a", "111");
        map.put("333", "111");
        ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement(sql);
        System.out.println("parsedSql = " + parsedSql);
        MapSqlParameterSource parameterSource = new MapSqlParameterSource(map);

        String s = NamedParameterUtils.substituteNamedParameters(sql, parameterSource);
        Object[] objects = NamedParameterUtils.buildValueArray(parsedSql, parameterSource, null);
        for (Object object : objects) {
            System.out.println("object = " + object);
        }
    }

    /**
     * BeanPropertyRowMapper 中得私有工具类
     * @throws Exception
     */
    @Test
    public void testUnderScoreName() throws Exception {
        String underScore = underscoreName("UnderScore");
        System.out.println("UnderScore = " + underScore);
    }
    private String underscoreName(String name) {
        if (!StringUtils.hasLength(name)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append(name.substring(0, 1).toLowerCase());
        for (int i = 1; i < name.length(); i++) {
            String s = name.substring(i, i + 1);
            String slc = s.toLowerCase();
            if (!s.equals(slc)) {
                result.append("_").append(slc);
            }
            else {
                result.append(s);
            }
        }
        return result.toString();
    }
}
