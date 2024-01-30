package com.javaapi.test.buisness.dao.mybatis.features.datafilter;

import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;


/**
 * 可以参考
 * https://blog.csdn.net/Liu_York/article/details/88053053
 * @author wk
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
@Slf4j
@Component
public class MybatisDataFilterInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        //获取StatementHandler构造器
        StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
        // 通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
        MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(delegate, "mappedStatement");
        SqlCommandType commandType = mappedStatement.getSqlCommandType();
        if (SqlCommandType.SELECT.equals(commandType)) {
            // 由classname+methodname 组成,列如:com.javaapi.test.buisness.dao.mybatis.usage.optimisticLock.CashBookDao.selectOne
            String sqlId = mappedStatement.getId();
            BoundSql boundSql = delegate.getBoundSql();

            String sql = boundSql.getSql();

            log.info("sql语句1:{}", sql);
            Statement statement = CCJSqlParserUtil.parse(sql);
            log.info("sql语句2:{}", boundSql.getSql());
            Select select = (Select) statement;
            PlainSelect selectBody = (PlainSelect) select.getSelectBody();
            //根据业务添加过滤条件请自行实现
            StringBuilder sqlFilter = new StringBuilder(128);
            sqlFilter.append("1=1");
            buildWhereClause(selectBody, sqlFilter.toString());
            ReflectUtil.setFieldValue(boundSql, "sql", statement.toString());
        }
        return invocation.proceed();

    }


    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 这里需要空注解，否则sonar会不happy。
    }

    /**
     * TODO
     * 这里缺少insert的value 值,方便写入也加入指定条件
     */
    private void buildWhereClause(Insert select, String dataFilter) throws JSQLParserException {
    }

    /**
     * 构建查询语句额外的where条件
     */
    private void buildWhereClause(PlainSelect select, String dataFilter) throws JSQLParserException {
        if (select.getWhere() == null) {
            select.setWhere(CCJSqlParserUtil.parseCondExpression(dataFilter));
        } else {
            AndExpression and = new AndExpression(
                    CCJSqlParserUtil.parseCondExpression(dataFilter), select.getWhere());
            select.setWhere(and);
        }
    }

    /**
     * 构建更新语句额外的的查询条件
     */
    private void buildWhereClause(Update update, String dataFilter) throws JSQLParserException {
        if (update.getWhere() == null) {
            update.setWhere(CCJSqlParserUtil.parseCondExpression(dataFilter));
        } else {
            AndExpression and = new AndExpression(
                    CCJSqlParserUtil.parseCondExpression(dataFilter), update.getWhere());
            update.setWhere(and);
        }
    }

    /**
     * 构建删除语句额外的的查询条件
     */
    private void buildWhereClause(Delete delete, String dataFilter) throws JSQLParserException {
        if (delete.getWhere() == null) {
            delete.setWhere(CCJSqlParserUtil.parseCondExpression(dataFilter));
        } else {
            AndExpression and = new AndExpression(
                    CCJSqlParserUtil.parseCondExpression(dataFilter), delete.getWhere());
            delete.setWhere(and);
        }
    }

}