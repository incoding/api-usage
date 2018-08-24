package com.javaapi.test.buisness.data.json.fastjson.io.serialize.pojoToKey.ser;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.javaapi.test.buisness.constant.constant.classconstant.ConstantGame;

import java.io.IOException;
import java.lang.reflect.Type;

public class StudentSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.writeNull();
            return;
        }
        ConstantGame constantGame = null;
        if (object instanceof ConstantGame) {
            constantGame = (ConstantGame) object;

        }
        serializer.write(constantGame == null ? "":ConstantGame.getByDesc(constantGame.getDesc()));
    }
}