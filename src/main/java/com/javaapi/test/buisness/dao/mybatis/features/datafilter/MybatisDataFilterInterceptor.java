package com.javaapi.test.buisness.dao.mybatis.features.datafilter;

import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Statement;
//
//@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
//@Slf4j
//@Component
//public class MybatisDataFilterInterceptor implements Interceptor {
//    @Override
//    public Object intercept(Invocation invocation) throws Throwable {
//        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
//        //获取StatementHandler构造器
//        StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
//        // 通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
//        MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
//        SqlCommandType commandType = mappedStatement.getSqlCommandType();
//        if (SqlCommandType.SELECT.equals(commandType)) {
//            String sqlId = mappedStatement.getId();
//            BoundSql boundSql = delegate.getBoundSql();
//
//            String sql = boundSql.getSql();
//
//            log.info("sql语句1:{}", sql);
//            Statement statement = CCJSqlParserUtil.parse(sql);
//            log.info("sql语句2:{}", boundSql.getSql());
//            Select select = (Select) statement;
//            PlainSelect selectBody = (PlainSelect) select.getSelectBody();
//            //根据业务添加过滤条件请自行实现
//            StringBuilder sqlFilter = new StringBuilder(128);
//            sqlFilter.append("id=5 or 1=1");
//            buildWhereClause(selectBody, sqlFilter.toString());
//            ReflectUtil.setFieldValue(boundSql, "sql", statement.toString());
//        }
//        return invocation.proceed();
//
//    }
//
//    private void buildWhereClause(PlainSelect select, String dataFilter) throws JSQLParserException {
//        if (select.getWhere() == null) {
//            select.setWhere(CCJSqlParserUtil.parseCondExpression(dataFilter));
//        } else {
//            AndExpression and = new AndExpression(
//                    CCJSqlParserUtil.parseCondExpression(dataFilter), select.getWhere());
//            select.setWhere(and);
//        }
//    }
//}