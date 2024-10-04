package com.javaapi.test.application.spel;

import com.javaapi.test.application.spel.param.PubBidPriceDayaheadAvgDto;
import com.javaapi.test.application.spel.param.PubBidPriceDayaheadAvgParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.testng.collections.Lists;

@Slf4j
public class TestTransfer {
    @Test
    public void test() {
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
    public void testTemplate() {
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

    private static PubBidPriceDayaheadAvgParam getParam() {
        PubBidPriceDayaheadAvgParam pubBidPriceDayaheadAvgParam = new PubBidPriceDayaheadAvgParam();
        pubBidPriceDayaheadAvgParam.setInfoDate("2024-10-03");
        PubBidPriceDayaheadAvgDto pubBidPriceDayaheadAvgDto = new PubBidPriceDayaheadAvgDto();
        pubBidPriceDayaheadAvgDto.setNodeName("hb");
        pubBidPriceDayaheadAvgDto.setTargetType("");
        pubBidPriceDayaheadAvgDto.setGuid("guid");
        pubBidPriceDayaheadAvgDto.setCreateDate("2024-10-13 12:00:00");
        pubBidPriceDayaheadAvgDto.setMyType("F");
        pubBidPriceDayaheadAvgParam.setDataList(Lists.newArrayList(pubBidPriceDayaheadAvgDto));
        return pubBidPriceDayaheadAvgParam;
    }

}
