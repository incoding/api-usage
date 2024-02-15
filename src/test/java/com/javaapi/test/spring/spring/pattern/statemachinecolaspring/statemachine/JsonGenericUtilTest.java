package com.javaapi.test.spring.spring.pattern.statemachinecolaspring.statemachine;

import cn.hutool.extra.spring.SpringUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.javaapi.test.buisness.data.json.fastjson.annotation.jsontype.Student;
import com.javaapi.test.buisness.joint.outter.Result;
import com.javaapi.test.spring.spring.pattern.statemachinecolaspring.service.guarantee.transit.nonesense.PayWaitToPayWait2Transit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@Slf4j
public class JsonGenericUtilTest {

    @Resource
    StateMachineProxy stateMachineProxy;

    @Test
    public void test(){
        Map<String, Object> beansWithAnnotation = SpringUtil.getApplicationContext().getBeansWithAnnotation(Transit.class);
        for (Object value : beansWithAnnotation.values()) {
            Class<?> aClass = value.getClass();
            Type genericSuperclass = aClass.getGenericSuperclass();
            Type[] genericInterfaces = aClass.getGenericInterfaces();
            Map<String, List<Type>> classToGeneric = Maps.newHashMap();
            if (!aClass.equals(PayWaitToPayWait2Transit.class)) {
                continue;
            }
            Type contextType = null;
            for (int i = 0; i < genericInterfaces.length; i++) {
                Type genericInterface = genericInterfaces[i];
                log.info("class:{},genericInterfaces:{}",value, genericInterface);
                Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
                Type actualTypeArgument1 = ((ParameterizedType) genericInterface).getActualTypeArguments()[1];
                Type actualTypeArgument2 = ((ParameterizedType) genericInterface).getActualTypeArguments()[2];
                Type actualTypeArgument3 = ((ParameterizedType) genericInterface).getActualTypeArguments()[3];
                contextType = actualTypeArgument3;
                System.out.println("actualTypeArgument = " + actualTypeArgument);
                System.out.println("actualTypeArgument1 = " + actualTypeArgument1);
                System.out.println("actualTypeArgument2 = " + actualTypeArgument2);
                System.out.println("actualTypeArgument3 = " + actualTypeArgument3);
                Type[] actualTypeArguments = ((ParameterizedType) actualTypeArgument3).getActualTypeArguments();
                System.out.println("actualTypeArgument3sub = " + Arrays.toString(actualTypeArguments)+",length:"+actualTypeArguments.length);
                break;
            }
            log.info("class:{},gengericSuperclass:{}",value,genericSuperclass.getTypeName());
            String str = "{\"code\":\"200\",\"count\":1,\"data\":[{\"name\":\"this is name\"}],\"failed\":false,\"msg\":\"成功\",\"success\":true}";
            Result<List<Student>> o = JSON.parseObject(str, contextType);
            System.out.println("o = " + JSON.toJSONString(o));
        }
    }


    /**
     * 获取接口上的泛型信息
     */
    @Test
    public void testScanContextParam(){
        Map<String, Object> beansWithAnnotation = SpringUtil.getApplicationContext().getBeansWithAnnotation(Transit.class);
        Map<String, Map<String,Type>> classToGeneric = Maps.newHashMap();
        for (Object value : beansWithAnnotation.values()) {
            Class<?> aClass = value.getClass();
            Type[] genericInterfaces = aClass.getGenericInterfaces();
            for (Type genericInterface : genericInterfaces) {
                if (!((ParameterizedTypeImpl) genericInterface).getRawType().getName().equals(IStateTransit.class.getName())) {
                    continue;
                }
                Map<String, Type> keyToType = Maps.newHashMap();
                keyToType.put("state", ((ParameterizedType) genericInterface).getActualTypeArguments()[0]);
                keyToType.put("event", ((ParameterizedType) genericInterface).getActualTypeArguments()[1]);
                keyToType.put("context", ((ParameterizedType) genericInterface).getActualTypeArguments()[2]);
                keyToType.put("result", ((ParameterizedType) genericInterface).getActualTypeArguments()[3]);
                classToGeneric.put(value.getClass().toString(), keyToType);
            }
        }
        System.out.println("classToGeneric = " + JSON.toJSONString(classToGeneric));
    }
}
