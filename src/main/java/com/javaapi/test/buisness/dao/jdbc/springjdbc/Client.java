package com.javaapi.test.buisness.dao.jdbc.springjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试 spring jdbc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {
	@Autowired
	JdbcTemplate	jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate nameJdbc;

	@SuppressWarnings("unchecked")
	@Test
	public void testJdbcTemplateSelect() {
		final String select = "select * from csc_sns_dev.tbl_b where val=?";
//		jdbcTemplate.query(select, null);
		jdbcTemplate.query(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				con.prepareStatement(select, new String[]{});
				return null;
			}
		}, new RowMapper<Map<String,String>>() {

			@Override
			public Map<String, String> mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return null;
			}

		} );

	}
	@Test
	public void testJdbcTemplateUpdate() {
		String id = "1";
		String sql = "update csc_sns_dev.tbl_b set val='kk'  where id=" + id;
		int result = jdbcTemplate.update(sql);
		System.out.println(result);
	}

    /**
     * 仅支持jdk里的类型， 不支持自己定义的类型
     * @throws Exception
     */
    @Test
    public void testQueryForObject() throws Exception {
        String val = jdbcTemplate.queryForObject("SELECT val FROM tbl_b WHERE id=?", new Object[]{1}, String.class);
        System.out.println("s = " + val);
    }
    /**
     * 仅支持jdk里的类型， 不支持自己定义的类型
     * @throws Exception
     */
    @Test
    public void testQueryForList() throws Exception {
        List<String> strings = jdbcTemplate.queryForList("SELECT val FROM tbl_b WHERE id=?", String.class);
        System.out.println("strings = " + strings);
    }

    /**
     * 将取出来的数据装进map
     * @throws Exception
     */
    @Test
    public void testQueryForListMap() throws Exception {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT val FROM tbl_b WHERE id=?");
        System.out.println("maps = " + maps);
    }

    /**
     * 可以直接映射自定义实体的写法
     * @throws Exception
     */
    @Test
    public void testBean() throws Exception {
        String sql = "SELECT * FROM csc_sns_dev.tbl";
        List<TblB> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TblB.class), new Object[]{1});
        System.out.println("query = " + query);
    }

    /**
	 * spring 提供得NamedParameterJdbcTemplate,支持命名参数绑定
	 */
	@Test
	public void testNamedJdbcTemplateUpdate() {
		String sql = "select count(1) from csc_sns_dev.tbl_b  where id=:id";
		Map<String,String> map =new HashMap<>();
		map.put("id", "1");
//		int result = nameJdbc.queryForInt(sql, map);
//		System.out.println(result);
	}
    @Test
    public void testNamedJdbcTemplateU() {
        String sql = "select count(1) from csc_sns_dev.tbl_b  where id=:id";
        Map<String,String> map =new HashMap<>();
        map.put("id", "1");
        List<Map<String, Object>> maps = nameJdbc.queryForList(sql, map);
        System.out.println("maps = " + maps);
    }
}
