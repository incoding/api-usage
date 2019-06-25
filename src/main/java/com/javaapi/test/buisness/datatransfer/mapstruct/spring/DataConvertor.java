package com.javaapi.test.buisness.datatransfer.mapstruct.spring;

import com.javaapi.test.buisness.datatransfer.mapstruct.DataAfter;
import com.javaapi.test.buisness.datatransfer.mapstruct.DataBefore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * componentModel = "spring" 该配置表示生成的实现类默认加上spring @Component注解，使用时可直接通过@Autowire进行注入，
 */
@Mapper(componentModel = "spring")
public interface DataConvertor {
    /**
     * 1 方法名可以任意
     * 2 如果有字段不同需要 Mappings 和子注解 Mapping进行注释
     */
    @Mappings({
            @Mapping(source = "age", target = "afterAge"),
            @Mapping(source = "height", target = "afterHeight")
    })
    public DataAfter vo2do(DataBefore df );
}
