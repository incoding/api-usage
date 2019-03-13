package com.javaapi.test.application.rpc.dubbo.facade;

import com.javaapi.test.application.rpc.dubbo.model.EnumSample;
import com.javaapi.test.application.rpc.dubbo.model.MsgInfo;

public interface DemoService {
	
    public void sayHello();
    
    public String returnHello();
    
    public MsgInfo returnMsgInfo(MsgInfo info);


    MsgInfo returnMsgInfo2(String name, EnumSample info);
}