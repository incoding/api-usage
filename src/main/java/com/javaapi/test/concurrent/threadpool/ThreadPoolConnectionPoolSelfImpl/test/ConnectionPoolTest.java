package com.javaapi.test.concurrent.threadpool.ThreadPoolConnectionPoolSelfImpl.test;

import java.sql.Connection;

public class ConnectionPoolTest {

	public static void main(String[] args) throws Exception {
		ConnectionPool connPool = new ConnectionPool(
				"oracle.jdbc.driver.OracleDriver",
				"jdbc:oracle:thin:@127.0.0.1:1521:ORCL", "scott", "tiger");

		connPool.createPool();
		Connection conn = connPool.getConnection();
		connPool.closeConnectionPool();
		connPool.setTestTable("EMP");
	}

}