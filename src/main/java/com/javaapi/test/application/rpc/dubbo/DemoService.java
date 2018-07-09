package com.javaapi.test.application.rpc.dubbo;
public interface DemoService {
	
    public void sayHello();
    
    public String returnHello();
    
    public MsgInfo returnMsgInfo(MsgInfo info);


    MsgInfo returnMsgInfo2(String name, EnumSample info);
}