package com.javaapi.test.application.spel;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestSpel {
    @Test
    public void test() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#root.purchaseName");
        Order order = new Order();
        order.setPurchaseName("张三");
        System.out.println(expression.getValue(order));
        System.out.println(parser.parseExpression("#root.getCustomName()").getValue(order));
    }

    public class Order {
        public String purchaseName;

        public String getPurchaseName() {
            return purchaseName;
        }

        public void setPurchaseName(String purchaseName) {
            this.purchaseName = purchaseName;
        }

        public String getCustomName(){
            return this.purchaseName + "custom";
        }
    }
}
