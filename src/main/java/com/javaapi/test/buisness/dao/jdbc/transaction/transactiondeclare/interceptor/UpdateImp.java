package com.javaapi.test.buisness.dao.jdbc.transaction.transactiondeclare.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("targetUpdateService")
public class UpdateImp implements IupdateService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void update() {
		String sql = "update tbl_b set val='kk2' where id=4";
		jdbcTemplate.update(sql);
        throw new RuntimeException("模拟错误");
    }

}
