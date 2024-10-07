package com.javaapi.test.application.spel;

import com.javaapi.test.application.spel.param.PubBidPriceDayaheadAvgDto;
import com.javaapi.test.application.spel.param.PubBidPriceDayaheadAvgParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.testng.collections.Lists;

import java.util.*;

@Slf4j
public class TestTransfer {
    @Test
    public void testStaticMethod() {
        PubBidPriceDayaheadAvgParam param = getParam();
        SpelExpressionParser parser = new SpelExpressionParser();
        PubBidPriceDayaheadAvgDto pubBidPriceDayaheadAvgDto = param.getDataList().get(0);
        log.info("结果是:{}",parser.parseExpression("T(com.javaapi.test.application.spel.MyType).getByName(#root.getMyType())").getValue(pubBidPriceDayaheadAvgDto));
        log.info("结果是:{}",parser.parseExpression("T(com.javaapi.test.application.spel.MyType).getByName(#root.getMyType())+'nihao'").getValue(pubBidPriceDayaheadAvgDto));

    }

    /**
     * 模版方式
     */
    @Test
    public void testParserTemplate() {
        ParserContext parserContext = new ParserContext() {
            @Override
            public boolean isTemplate() {
                return true;
            }

            @Override
            public String getExpressionPrefix() {
                return "#{";
            }

            @Override
            public String getExpressionSuffix() {
                return "}";
            }
        };
        PubBidPriceDayaheadAvgParam param = getParam();
        SpelExpressionParser parser = new SpelExpressionParser();
        PubBidPriceDayaheadAvgDto pubBidPriceDayaheadAvgDto = param.getDataList().get(0);
        log.info("结果是:{}",parser.parseExpression("结果是 #{T(com.javaapi.test.application.spel.MyType).getByName(#root.getMyType())} 哈哈",parserContext).getValue(pubBidPriceDayaheadAvgDto));

    }

    @Test
    public void testEvaluationContextThis(){
        // create an array of integers
        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2,3,5,7,11,13,17));

// create parser and set variable 'primes' as the array of integers
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("primes", primes);

// all prime numbers > 10 from the list (using selection ?{...})
// evaluates to [11, 13, 17]
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
                "#primes.?[#this>10]").getValue(context);
        System.out.println("primesGreaterThanTen = " + primesGreaterThanTen);
    }

    @Test
    public void testEvaluationContextDynamicThis(){
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        String expressionString = "#This.nodeName+':'+#root.infoDate";
        Map<String, String> template = new HashMap<>();
        template.put("express", expressionString);

        PubBidPriceDayaheadAvgParam param = getParam();
        for (PubBidPriceDayaheadAvgDto pubBidPriceDayaheadAvgDto : param.getDataList()) {
            context.setVariable("this", pubBidPriceDayaheadAvgDto);
            context.setVariable("This", pubBidPriceDayaheadAvgDto);
            log.info("this和root是:{}",parser.parseExpression(template.get("express")).getValue(context,param));
        }
    }

    private static PubBidPriceDayaheadAvgParam getParam() {
        PubBidPriceDayaheadAvgParam pubBidPriceDayaheadAvgParam = new PubBidPriceDayaheadAvgParam();
        pubBidPriceDayaheadAvgParam.setInfoDate("2024-10-03");
        PubBidPriceDayaheadAvgDto pubBidPriceDayaheadAvgDto = new PubBidPriceDayaheadAvgDto();
        pubBidPriceDayaheadAvgDto.setNodeName("hb");
        pubBidPriceDayaheadAvgDto.setTargetType("");
        pubBidPriceDayaheadAvgDto.setGuid("guid");
        pubBidPriceDayaheadAvgDto.setCreateDate("2024-10-13 12:00:00");
        pubBidPriceDayaheadAvgDto.setMyType("F");
        PubBidPriceDayaheadAvgDto target = new PubBidPriceDayaheadAvgDto();
        BeanUtils.copyProperties(pubBidPriceDayaheadAvgDto, target);
        target.setNodeName("bj");
        pubBidPriceDayaheadAvgParam.setDataList(Lists.newArrayList(pubBidPriceDayaheadAvgDto,target));
        return pubBidPriceDayaheadAvgParam;
    }

}
