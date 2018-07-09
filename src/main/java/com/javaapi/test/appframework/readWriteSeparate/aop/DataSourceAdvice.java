package com.javaapi.test.appframework.readWriteSeparate.aop;

import com.javaapi.test.appframework.readWriteSeparate.annotation.Datasource;
import com.javaapi.test.appframework.readWriteSeparate.database.DataSourceSwitcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

//@Aspect
//@Component
public class DataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    // service方法执行之前被调用
    public void before(Method method, Object[] args, Object target) throws Throwable {



        log.info("切入点: " + target.getClass().getName() + "类中" + method.getName() + "方法");

        Datasource annotation = method.getAnnotation(Datasource.class);
        if (annotation !=null ){
            String value = annotation.value();
            if (value.equals("master")){
                DataSourceSwitcher.setMaster();
                log.info("切换到: master");
                return;
            }else if (value.equals("slave")){
                DataSourceSwitcher.setSlave();
                log.info("切换到: slave");
                return;
            }

        }


        if (method.getName().startsWith("insert") || method.getName().startsWith("create")
                || method.getName().startsWith("save") || method.getName().startsWith("edit")
                || method.getName().startsWith("update") || method.getName().startsWith("delete")
                || method.getName().startsWith("remove")) {
            log.info("切换到: master");
            DataSourceSwitcher.setMaster();
        } else {
            log.info("切换到: slave");
            DataSourceSwitcher.setSlave();
        }
    }

    // service方法执行完之后被调用
    public void afterReturning(Object var1, Method var2, Object[] var3, Object var4) throws Throwable {
        DataSourceSwitcher.setMaster(); // *****  加上这句解决运行数据库切换问题
    }

    // 抛出Exception之后被调用
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        DataSourceSwitcher.setSlave();
        log.info("出现异常,切换到: slave");
    }

}

