package com.javaapi.test.buisness.dao.mybatis.biz.bizdemo2;



public interface IUserMapper
{
    /**
     * 该方法名对应User.xml中查询语句的id,User.xml中的namespace对应该接口的路径 
     * com.mybatis.interfac.IUserMapper
     */
    public User selectUserByID(int id);
}