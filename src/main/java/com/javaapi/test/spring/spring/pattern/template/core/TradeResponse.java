
package com.javaapi.test.spring.spring.pattern.template.core;


import java.io.Serializable;

/**
 * 交易服务处理结果
 */
public class TradeResponse<Response extends Serializable> /*extends BaseVO<String> */ {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 返回主体内容
     */
    private Response data;

    public TradeResponse() {
    }

    /**
     * 带参数构造函数
     *
     * @param data
     */
    public TradeResponse(Response data) {
        this.data = data;
    }

//    /**
//     */
//    @Override
//    public String getId() {
//        return getTraceId();
//    }
//
//    /**
//     */
//    @Override
//    public void setId(String id) {
//        setTraceId(id);
//    }

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */
    public Response getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     *
     * @param data value to be assigned to property data
     */
    public void setData(Response data) {
        this.data = data;
    }

}
