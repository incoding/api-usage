package com.javaapi.test.spring.spring.custom.customlog.constants;

import com.javaapi.test.spring.spring.custom.customlog.enums.ChildNameEnum;
import com.javaapi.test.spring.spring.custom.customlog.enums.ServiceNameEnum;

/**
 * Created by user on 2019/8/3
 */
public class Constants {

    public static final String SERVICE_ID_SEPARATOR                       = "|";


    public static final String DEFAULT_HANDLER_TAG = ServiceNameEnum.COMMON.name() + SERVICE_ID_SEPARATOR + ChildNameEnum.DEFAULT.name();

}
