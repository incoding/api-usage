package com.javaapi.test.buisness.data.json.fastjson.io.serialize.enumToJson.part;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class StatusSerializer implements ObjectSerializer {


    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.writeNull();
            return;
        }
        serializer.write(Status.value((Status) object));
    }
}