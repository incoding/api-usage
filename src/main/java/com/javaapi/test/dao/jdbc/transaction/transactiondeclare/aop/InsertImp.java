package com.javaapi.test.dao.jdbc.transaction.transactiondeclare.aop;

import org.springframework.jdbc.core.JdbcTemplate;

//@Service("targetInsertService")
public class InsertImp implements IinsertService{


//	@Autowired
	JdbcTemplate jdbcTemplate;
	
//	@Autowired
	IupdateService iupdateService;
	
//	private static final String sql = "insert csc_sns_dev.tbl_b (id,val) values(3,'kk')";
	private static final String sql = "update matchs set league_name='斯伐乙西1'  where bet007_id=595959";
	
	@Override
	public void insert() {
		jdbcTemplate.update(sql);
		// 这是个服务
		iupdateService.update();
		throw new RuntimeException("方法抛出异常,导致异常回滚");
	}

}
