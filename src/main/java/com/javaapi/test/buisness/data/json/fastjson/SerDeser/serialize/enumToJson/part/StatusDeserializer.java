package com.javaapi.test.buisness.data.json.fastjson.SerDeser.serialize.enumToJson.part;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

public class StatusDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type,
                            Object fieldName) {
        JSONLexer lexer = parser.getLexer();
        int value = lexer.intValue();
        return (T) Status.create(value);
    }

    @Override
    public int getFastMatchToken() {
        // TODO Auto-generated method stub
        return 0;
    }
}