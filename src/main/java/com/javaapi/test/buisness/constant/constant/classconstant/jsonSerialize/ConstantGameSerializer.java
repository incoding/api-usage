package com.javaapi.test.buisness.constant.constant.classconstant.jsonSerialize;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.javaapi.test.buisness.constant.constant.classconstant.ConstantGame;

import java.io.IOException;
import java.lang.reflect.Type;

public class ConstantGameSerializer implements ObjectSerializer {


    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.writeNull();
            return;
        }
        String desc = null;
        if (object instanceof ConstantGame) {
            ConstantGame constantGame = (ConstantGame) object;
            desc = constantGame.getDesc();

        }
        serializer.write(desc);
    }
}