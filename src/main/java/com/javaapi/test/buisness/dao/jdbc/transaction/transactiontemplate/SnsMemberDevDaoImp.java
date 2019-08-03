package com.javaapi.test.buisness.dao.jdbc.transaction.transactiontemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SnsMemberDevDaoImp implements SnsMemberDevDaoI {

	@Autowired
	private JdbcTemplate	jdbcTemplate;
	@Override
	public int update() {
		String id = "1";
		String sql = "update csc_sns_dev.tbl_b set val='kk'  where id="
				+ id;
		int updated = jdbcTemplate.update(sql);
		return updated;
	}

}
