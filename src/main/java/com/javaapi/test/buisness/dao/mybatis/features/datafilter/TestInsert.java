package com.javaapi.test.buisness.dao.mybatis.features.datafilter;


import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.insert.Insert;
import org.junit.Test;

public class TestInsert {

    /**
     * 构建插入语句
     */
    @Test
    public void buildInsertSql() throws JSQLParserException {
        Insert insert = (Insert) CCJSqlParserUtil.parse("insert into mytable (col1,col2,col4) values (1,2,4);");
        // 设置插入列
        insert.addColumns(new Column("col3"));
        System.out.println("insert.getValues() = " + insert.getValues());
        System.out.println("insert.getValues().getExpressions() = " + insert.getValues().getExpressions());
        ExpressionList<Expression> expressions = (ExpressionList<Expression>) insert.getValues().getExpressions();
        expressions.add(new LongValue(3));
        // INSERT INTO mytable (col1, col2, col4, col3) VALUES (1, 2, 4, 3)
        System.err.println(insert);
    }

    /**
     * 只有一个字段的时候会报错
     */
    @Test
    public void buildInsertErrorSql() throws JSQLParserException {
        Insert insert = (Insert) CCJSqlParserUtil.parse("insert into mytable (col1) values (1);");
        // 设置插入列
        insert.addColumns(new Column("col3"));
        System.out.println("insert.getValues() = " + insert.getValues());
        System.out.println("insert.getValues().getExpressions() = " + insert.getValues().getExpressions());
        ExpressionList<Expression> expressions = (ExpressionList<Expression>) insert.getValues().getExpressions();
        expressions.add(new LongValue(3));
        // INSERT INTO mytable (col1, col2, col4, col3) VALUES (1, 2, 4, 3)
        System.err.println(insert);
    }


}
