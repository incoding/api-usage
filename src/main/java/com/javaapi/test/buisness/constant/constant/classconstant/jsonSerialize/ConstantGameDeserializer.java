package com.javaapi.test.buisness.constant.constant.classconstant.jsonSerialize;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.javaapi.test.buisness.constant.constant.classconstant.ConstantGame;

import java.lang.reflect.Type;

/**
 * 注意
 *         lexer.nextToken(JSONToken.COMMA);
 * http://zoufelix.cn/2016/11/18/%E8%87%AA%E5%AE%9A%E4%B9%89-fastjson-%E5%AF%B9%E8%B1%A1%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96/
 */
public class ConstantGameDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type,
                            Object fieldName) {
        JSONLexer lexer = parser.getLexer();
        String s = lexer.stringVal();
        // 注意这里
        lexer.nextToken(JSONToken.COMMA);
        return (T) ConstantGame.getByDesc(s);
    }

    @Override
    public int getFastMatchToken() {
        // TODO Auto-generated method stub
        return 0;
    }
}