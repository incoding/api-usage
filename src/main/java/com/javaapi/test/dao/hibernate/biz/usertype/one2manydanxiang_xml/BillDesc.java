package com.javaapi.test.dao.hibernate.biz.usertype.one2manydanxiang_xml;

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
 * @author hncw
 * http://blog.csdn.net/daryl715/article/details/1927502 (好)
 *
 */
public class BillDesc implements UserType {
	private String index = "";
	private String name = "";
	  private   static   final   int [] TYPES  =   new   int [] {Types.VARCHAR,Types.VARCHAR};
	@Override
	public int[] sqlTypes() {
		return TYPES;
	}

	@Override
	public Class<BillDesc> returnedClass() {
		return BillDesc.class;
	}

	@Override
	public boolean equals(Object obj, Object obj1) throws HibernateException {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj1.getClass() != obj.getClass())
			return false;
		BillDesc other = (BillDesc) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	
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
		String name =StringType.INSTANCE.nullSafeGet(resultset, as[1], sessionimplementor);
		return BankName.getByIndex(index);
	}

	@Override
	public void nullSafeSet(PreparedStatement preparedstatement, Object obj,
			int i, SessionImplementor sessionimplementor)
			throws HibernateException, SQLException {
		
	}

	@Override
	public Object deepCopy(Object obj) throws HibernateException {
		BillDesc billDesc = new BillDesc();
		billDesc.setName("kkSelfConfig");
		return billDesc;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable disassemble(Object obj) throws HibernateException {
		return null;
	}

	@Override
	public Object assemble(Serializable serializable, Object obj)
			throws HibernateException {
		return null;
	}

	@Override
	public Object replace(Object obj, Object obj1, Object obj2)
			throws HibernateException {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillDesc other = (BillDesc) obj;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
