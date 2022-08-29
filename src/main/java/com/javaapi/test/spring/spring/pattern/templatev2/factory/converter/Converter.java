package com.javaapi.test.spring.spring.pattern.templatev2.factory.converter;

import com.alibaba.fastjson.JSON;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseRequestDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.base.BaseResponseDTO;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.context.ResponseContext;
import com.javaapi.test.spring.spring.pattern.templatev2.factory.exception.ConverterException;

import java.io.Serializable;

/**
 *
 */
public interface Converter<ReqDTO extends BaseRequestDTO, ResDTO extends BaseResponseDTO, ReqVO extends Serializable, ResVO extends Serializable> {

    /**
     * 网关请求参数转换为业务层需要的入参模型
     *
     * @param request 网关请求参数
     * @return 业务层入参模型
     * @throws ConverterException 转换异常
     */
    ReqVO requestToVO(ReqDTO request) throws ConverterException, IllegalAccessException;

    /**
     * 业务层返回的数据模型转换层网关需要的应答参数
     *
     * @param vo 业务层返回的数据模型
     * @return 网关应答参数
     * @throws ConverterException 转换异常
     */
    ResDTO voToResponse(ResponseContext<ResVO> vo) throws ConverterException;

    /**
     * 默认网关返回参数方法
     *
     * @param vo
     * @param resDTOClass
     * @return
     */
    default ResDTO getResDTO(ResponseContext<ResVO> vo, Class<ResDTO> resDTOClass) {
        ResDTO resDTO = null;
        try {
            resDTO = resDTOClass.newInstance();
            resDTO.setErrorCode(vo.getCode());
            resDTO.setErrorMessage(vo.getMessage());
            resDTO.setSuccess(vo.isSuccess());
        } catch (InstantiationException e) {
            // not happen
        } catch (IllegalAccessException e) {
            // not happen
        }

        return resDTO;
    }

    /**
     * @param vo
     * @param resDTOClass
     * @return
     */
    default ResDTO getResDTO2(ResponseContext<ResVO> vo, Class<ResDTO> resDTOClass) {
        ResDTO resDTO = JSON.parseObject(JSON.toJSONString(vo.getResponse()), resDTOClass);
        resDTO.setErrorCode(vo.getCode());
        resDTO.setErrorMessage(vo.getMessage());
        resDTO.setSuccess(vo.isSuccess());

        return resDTO;
    }

    /**
     * @param vo
     * @param clazz
     * @return
     */
    default ResDTO parseResponseObject(ResponseContext<ResVO> vo, Class<ResDTO> clazz) {
        ResDTO ret = JSON.parseObject(JSON.toJSONString(vo.getResponse()), clazz);
        if (ret == null) {
            try {
                ret = clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ret.setErrorCode(vo.getCode());
        ret.setErrorMessage(vo.getMessage());
        ret.setSuccess(vo.isSuccess());
        return ret;
    }

}
