package com.javaapi.test.buisness.dao.jdbc.transaction.transactiondeclare.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("targetUpdateService")
public class UpdateImp implements IupdateService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void update() {
		String sql = "update csc_sns_dev.tbl_b set val='kk' where id=4";
		jdbcTemplate.update(sql);
	}

}
