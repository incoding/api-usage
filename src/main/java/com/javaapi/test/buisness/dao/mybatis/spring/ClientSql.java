package com.javaapi.test.buisness.dao.mybatis.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.javaapi.test.buisness.dao.mybatis.biz.Social;

/**
 * http://mybatis.github.io/mybatis-3/zh/dynamic-sql.html
 * CREATE TABLE `tbl_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `val` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Transactional
public class ClientSql {

	@Autowired
	SqlSessionTemplate	sqlSessionTemplate;

	/**
	 * where 只能处理and 或or 在前面得
	 */
	@Test
	public void testWhereBefore() {
		Map<String,String> map = new HashMap<>();
		map.put("param1", "1");
		List<Map<String,String>> selectList = sqlSessionTemplate.selectList("testSqlNamespace.selectWhereAndBefore",map);
		for (Map<String, String> tmp : selectList) {
			System.out.println(tmp);
		}
	}
	
	/**
	 * where 标签无法去掉后面的and
	 */
	@Test
	public void testWhereAfter() {
		Map<String,String> map = new HashMap<>();
		map.put("param1", "1");
		List<Map<String,String>> selectList = sqlSessionTemplate.selectList("testSqlNamespace.selectWhereAndAfter",map);
		for (Map<String, String> tmp : selectList) {
			System.out.println(tmp);
		}
	}
	/**
	 * set 标签不能处理逗号在前
	 */
	@Test
	public void testUpdateSetBefore() {
		Map<String,String> map = new HashMap<>();
		map.put("param1", "1");
		int update = sqlSessionTemplate.update("testSqlNamespace.updateSetBefore", map);
		System.err.println(update);
	}
	/**
	 * set 只能处理,逗号在后面得
	 */
	@Test
	public void testUpdateSetAfter() {
		Map<String,String> map = new HashMap<>();
		map.put("param1", "1");
		int update = sqlSessionTemplate.update("testSqlNamespace.updateSetAfter", map);
		System.err.println(update);
	}
	/**
	 * 利用trim去掉前面的and 或者or
	 */
	@Test
	public void testSelectTrimAndBefore() {
		Map<String,String> map = new HashMap<>();
		map.put("param1", "1");
		List<Object> selectList = sqlSessionTemplate.selectList("testSqlNamespace.selectTrimAndBefore", map);
		System.err.println(selectList);
	}
	/**
	 * 利用trim去掉后面的 逗号
	 */
	@Test
	public void testUpdateTrimAfter() {
		Map<String,String> map = new HashMap<>();
		map.put("param1", "1");
		int update = sqlSessionTemplate.update("testSqlNamespace.updateTrimAfter", map);
		System.err.println(update);
	}
//	------------
	/**
	 * 测试foreach 传入tmpList,
	 * 但是xml里要用list接收
	 */
	@Test
	public void testSelectForEachList() {
		List<Integer> tmpList = new ArrayList<>();
		tmpList.add(1);
		tmpList.add(2);
		tmpList.add(3);
		List<Object> selectList = sqlSessionTemplate.selectList("testSqlNamespace.selectForeachList", tmpList);
		System.err.println(selectList);
	}
	/**
	 * 测试foreach map 传入key为ids,
	 * xml里用ids接受
	 * 
	 * 
    如果传入的是单参数且参数类型是一个List的时候，collection属性值为list
    如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array
    如果传入的参数是多个的时候，我们就需要把它们封装成一个Map了， 当然单参数也可以封装成map，实际上如果你在传入参数的时候，在MyBatis里面也是会把它封装成一个Map的，map的key就是参数名，所以这个时候collection属性值就是传入的List或array对象在自己封装的map里面的key</br>
	http://itindex.net/detail/46531-mybatis-sql
	 */
	@Test
	public void testSelectForEachMap() {
		List<Integer> tmpList = new ArrayList<>();
		tmpList.add(1);
		tmpList.add(2);
		tmpList.add(3);
		Map<String,Object> map = new HashMap<>();
		map.put("ids", tmpList);
		List<Social> selectList = sqlSessionTemplate.selectList("testSqlNamespace.selectForeachMap", map);
		System.out.println(selectList);
	}
	
	@Test
	public void testSelectForNotNull() throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("id", 0);
		List<Map<String,Object>> result = sqlSessionTemplate.selectList("testSqlNamespace.selectForNotNull", map);
		System.err.println(result);
	}
	@Test
	public void testUpdateForNotNull() throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("id", 0);
		List<Map<String,Object>> result = sqlSessionTemplate.selectList("testSqlNamespace.updateForNotNull", map);
		System.err.println(result);
	}
	
	
	/**
	 * 暂时没测好
	 */
	@Test
	public void testSelectForEachMap2() {
		Map<String,Object> map = new HashMap<>();
		map.put("1", 1);
		map.put("1", 2);
		map.put("1", 3);
		List<Social> selectList = sqlSessionTemplate.selectList("testSqlNamespace.selectForeachMap2", map);
		System.out.println(selectList);
	}
	/**mybatis 原生SqlSession支持 
	 * 测试返回Map<指定字段, 实体> 
	 */
	@Test
	public void testSelectForReturnMap() {
		Map<String,Object> map = new HashMap<>();
		Map<Integer, Social> selectMap = sqlSessionTemplate.selectMap("testSqlNamespace.selectReturnMap",map,"id");
		System.out.println(selectMap);
		System.out.println(selectMap.get(1));
	}
	//-----------
}
