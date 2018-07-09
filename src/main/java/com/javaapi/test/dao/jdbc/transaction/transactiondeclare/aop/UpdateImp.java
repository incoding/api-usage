package com.javaapi.test.dao.jdbc.transaction.transactiondeclare.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("targetUpdateService")
public class UpdateImp implements IupdateService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static String	sql	= "update tbl_b set val='kk' where id=4";
	// private static final String sql =
	// "update matchs set league_name='斯伐乙西2'  where bet007_id=595959";
	
	@Override
	public void update() {
		jdbcTemplate.update(sql);
        throw new RuntimeException("自定义异常");
    }

}
