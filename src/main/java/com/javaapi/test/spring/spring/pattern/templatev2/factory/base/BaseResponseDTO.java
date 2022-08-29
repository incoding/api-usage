package com.javaapi.test.spring.spring.pattern.templatev2.factory.base;

public class BaseResponseDTO extends BaseResult {
    private static final long serialVersionUID = -6141372643933452297L;
    private String traceId;

    public BaseResponseDTO() {
    }

    public String getTraceId() {
        return this.traceId;
    }

    public BaseResponseDTO setTraceId(String traceId) {
        this.traceId = traceId;
        return this;
    }

    public static BaseResponseDTO success(String traceId) {
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setTraceId(traceId);
        baseResponseDTO.setSuccess(true);
        return baseResponseDTO;
    }

    public String toString() {
        return "BaseResponseDTO(super=" + super.toString() + ", traceId=" + this.getTraceId() + ")";
    }
}
