package com.javaapi.test.buisness.dao.jdbc.transaction.transactiondeclare.proxy;

import org.springframework.jdbc.core.JdbcTemplate;

//@Service("targetInsertService")
public class InsertImp implements IinsertService{

	// @Autowired
	JdbcTemplate jdbcTemplate;
	
	// @Autowired
	// @Qualifier("proxyUpdateService")
	IupdateService iupdateService;
	
	@Override
	public void insert() {
		String sql = "insert csc_sns_dev.tbl_b (id,val) values(4,'kk')";
		jdbcTemplate.update(sql);
		// 这是个服务
		// iupdateService.update();
//		throw new RuntimeException("方法抛出异常,导致异常回滚");
	}

}
