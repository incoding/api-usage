package com.javaapi.test.buisness.joint.outter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 * 基础请求实体
 * </p>
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BaseRequest implements Serializable {

    /**
     * 应用标识
     */
    private static final long serialVersionUID = -1L;

    /**
     * 应用标识必填
     */
    private String appKey;

    /**
     * 业务线编号
     */
    private String busiCode;

    /**
     * 场景线编号
     */
    private String sceneCode;

    /**
     * 功能线编号
     */
    private String functionCode;

}
