package com.javaapi.test.buisness.dao.hibernate.biz.usertype.self;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
 
 
public enum OrganType implements PersistEnum<OrganType> ,Serializable{
    // 利用构造函数传参
    ORGANTYPE_DEPARTMENT(13), // 部门
    ORGANTYPE_ORGANMANAGER(14), // 管理机构
    ORGANTYPE_NONE(15);   //普通机构 无特殊含意的机构，类似企业中的总公司和分支机构，只有上下级关系。
 
    private static final Map<Integer, OrganType> map = new TreeMap<Integer, OrganType>();
     
    static {
        map.put(ORGANTYPE_DEPARTMENT.getOrgType(), ORGANTYPE_DEPARTMENT);
        map.put(ORGANTYPE_ORGANMANAGER.getOrgType(), ORGANTYPE_ORGANMANAGER);
        map.put(ORGANTYPE_NONE.getOrgType(), ORGANTYPE_NONE);
    }
     
    // 定义私有变量
    private int orgType ;
 
    // 构造函数，枚举类型只能为私有
 
 
    @Override
    public Integer getPersistedValue() {
        return getOrgType();
    }
 
    private OrganType(int orgType) {
		this.orgType = orgType;
	}

	public int getOrgType() {
		return orgType;
	}

	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	@Override
    public OrganType returnEnum(Integer persistedValue) {
        return map.get(persistedValue);
    }
 
    @Override
    public Map<Integer, OrganType> getAllValueMap() {
        return map;
    }         
}