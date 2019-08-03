package com.javaapi.test.buisness.dao.hibernate.biz.usertype.one2manydanxiang_xml;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.StringType;
import org.hibernate.usertype.UserType;

/**
 *http://blog.csdn.net/daryl715/article/details/1927502
 *
 */
public class BankNameTransfer implements UserType{
	  /**
	 *  /* 有几个字段就有几个值，这里容易出错，要多注意 */
	private   static   final   int [] TYPES  =   new   int [] {Types.VARCHAR};

	@Override
	public int[] sqlTypes() {
		return TYPES;
	}

	@Override
	public Class<BankName> returnedClass() {
		return BankName.class;
	}

	@Override
	public boolean equals(Object obj, Object obj1) throws HibernateException {
		BankName bank1 = (BankName) obj;
		BankName bank2 = (BankName) obj1;
		if(bank1.getIndex().equals(bank2.getIndex())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode(Object obj) throws HibernateException {
		return 0;
	}

	@Override
	public Object nullSafeGet(ResultSet resultset, String[] as,
			SessionImplementor sessionimplementor, Object obj)
			throws HibernateException, SQLException {
		String index =StringType.INSTANCE.nullSafeGet(resultset, as[0], sessionimplementor);
		BankName byIndex = BankName.getByIndex(index);
		return byIndex;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object obj,
			int i, SessionImplementor sessionimplementor)
			throws HibernateException, SQLException {
		BankName bank1 = (BankName) obj;
		 if (obj == null) {
             st.setNull(i, Types.VARCHAR);
//             st.setNull(i+1, Types.VARCHAR);
       } else {
           st.setString(i, bank1.getIndex());
//           st.setString(i + 1, address.getWorkAddr());
       }		
	}

	@Override
	public Object deepCopy(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		return obj;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object obj) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object assemble(Serializable serializable, Object obj)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object replace(Object obj, Object obj1, Object obj2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
