package com.javaapi.test.spring.spring.pattern.templatev3;



import javax.servlet.http.HttpServletResponse;


public interface IExportExcelRunner {
    /**
     * 执行导出
     *
     * @param response
     * @param exportReqVO
     */
    void run(HttpServletResponse response, CommonExportReqVO exportReqVO);
}
