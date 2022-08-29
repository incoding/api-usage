package com.javaapi.test.spring.spring.pattern.templatev2.factory.formatter;

import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseRequestDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseResponseDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.GatewayFilterContext;

import java.io.Serializable;

/**
 *
 */
public interface Formatter<ReqDTO extends BaseRequestDTO, ResDTO extends BaseResponseDTO, ReqVO extends Serializable, ResVO extends Serializable> {
    void dealResponse(ReqDTO request, ResDTO response, GatewayFilterContext<ReqVO, ResVO> context);
}
