package com.javaapi.test.buisness.dao.mybatis.features.datafilter;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.CallableStatementHandler;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.SimpleStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

//public class RoutingStatementHandler implements StatementHandler {
//    private final StatementHandler delegate;
//
//    public RoutingStatementHandler(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
//        switch (ms.getStatementType()) {
//            case STATEMENT:
//                this.delegate = new SimpleStatementHandler(executor, ms, parameter, rowBounds, resultHandler, boundSql);
//                break;
//            case PREPARED:
//                this.delegate = new PreparedStatementHandler(executor, ms, parameter, rowBounds, resultHandler, boundSql);
//                break;
//            case CALLABLE:
//                this.delegate = new CallableStatementHandler(executor, ms, parameter, rowBounds, resultHandler, boundSql);
//                break;
//            default:
//                throw new ExecutorException("Unknown statement type: " + ms.getStatementType());
//        }
//
//    }
//}