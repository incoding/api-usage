package com.javaapi.test.dao.jdbc.transaction.transactiondeclare.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("targetUpdateService")
@Transactional
public class UpdateImp implements IupdateService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final String	sql	= "update test.tbl_b set val='kk' where id=4";

	// private static final String sql =
	// "update matchs set league_name='斯伐乙西2'  where bet007_id=595959";
	
	@Override
	public void update() {
		jdbcTemplate.update(sql);
        throw new RuntimeException("自定义异常");
    }

}
