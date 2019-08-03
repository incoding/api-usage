package com.javaapi.test.buisness.dao.jdbc.transaction.transactiondeclare.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 通过annotation实现事务
 * 1 http://sishuok.com/forum/blogPost/list/2506.html
 * 2 事务配置的5种方式
 *
 * ==============
 * 注解使用InfrastructureAdvisorAutoProxyCreator 进行事物的自动代理
 * 使用BeanFactoryTransactionAttributeSourceAdvisor作为advisor
 * =======
 * getBeanPostProcessors()可以发现多个自动代理,则最后一个自动代理生成的代理会覆盖前面的,也就是最后生成的代理有效
 * applyBeanPostProcessorsAfterInitialization():423, AbstractAutowireCapableBeanFactory {org.springframework.beans.factory.support}
 initializeBean():1579, AbstractAutowireCapableBeanFactory {org.springframework.beans.factory.support}
 doCreateBean():539, AbstractAutowireCapableBeanFactory {org.springframework.beans.factory.support}
 createBean():476, AbstractAutowireCapableBeanFactory {org.springframework.beans.factory.support}
 getObject():303, AbstractBeanFactory$1 {org.springframework.beans.factory.support}
 getSingleton():230, DefaultSingletonBeanRegistry {org.springframework.beans.factory.support}
 doGetBean():299, AbstractBeanFactory {org.springframework.beans.factory.support}
 getBean():194, AbstractBeanFactory {org.springframework.beans.factory.support}
 getBean():956, AbstractApplicationContext {org.springframework.context.support}
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class Client {

    @Autowired
    ApplicationContext app;
//    @Autowired
//    IupdateService iupdateService;
//

//    @Test
////    @Transactional
//    public void testUpdate() {
//
//        iupdateService.update();
//    }

    @Test
    public void testUpdate() {
        IupdateService iupdateService = (IupdateService) app.getBean("targetUpdateService");
        iupdateService.update();
    }
}
