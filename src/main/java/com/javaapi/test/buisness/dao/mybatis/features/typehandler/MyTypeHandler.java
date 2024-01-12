package com.javaapi.test.buisness.dao.mybatis.features.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class MyTypeHandler extends BaseTypeHandler<UserInfo> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			UserInfo parameter, JdbcType jdbcType) throws SQLException {
		String address = parameter.getPhone() + "@" + parameter.getEmail();
		ps.setString(i, address);
	}

	@Override
	public UserInfo getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return dealType(rs.getString(columnName));
	}



	@Override
	public UserInfo getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return dealType(rs.getString(columnIndex));
	}

	@Override
	public UserInfo getNullableResult(CallableStatement cs,
			int columnIndex) throws SQLException {
		return dealType(cs.getString(columnIndex));
	}

	private UserInfo dealType(String result) {
		String phone = result.split("@")[0];
		String email = result.split("@")[1];
		UserInfo testTypeHandler = new UserInfo();
		testTypeHandler.setEmail(email);
		testTypeHandler.setPhone(phone);
		return testTypeHandler;
	}
}
