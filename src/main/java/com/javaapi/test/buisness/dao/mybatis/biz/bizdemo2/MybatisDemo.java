package com.javaapi.test.buisness.dao.mybatis.biz.bizdemo2;


import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**参考见
 * http://www.cnblogs.com/david-rui/p/3603645.html</br>
 * http://blog.csdn.net/bk76873063/article/details/24603305</br>
 * http://www.iteye.com/topic/1060588</br>
 * 如果不用这个mapper,则每个dao实现类都要自己调用下sqltemplate的方法</br>
 *  如果自己的dao实现没有其他逻辑 而只单纯调用sqltemplate的方法.则可以直接使用方式二当做dao的实现</br>
 * 这个例子暂时不能跑</br>
 */
public class MybatisDemo
{
    //这里采用了静态单列模式确保SqlsessionFactory的唯一性,
    private static SqlSessionFactory sessionFactory=null;
    private static Reader reader=null;
    static
    {
        try
        {
            reader = Resources.getResourceAsReader("Configuration.xml");
            //从xml配置文件中构建sessionFactory
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    private static SqlSessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
    
    public static void main(String[] args)
    {
        SqlSession session = null;
        try
        {
            session = getSessionFactory().openSession();
        
            //方式1:User user = session.selectOne("com.mybatis.entity.UserMapper.selectUserByID",1);

            //方法2:接口编程
            IUserMapper usermapper = session.getMapper(IUserMapper.class);
            User user = usermapper.selectUserByID(1);
            System.out.println(user.getUserAddress());
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }finally
        {
            session.close();
        }
    }

}