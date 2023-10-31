package com.javaapi.test.spring.spring.pattern.templatev3;

import lombok.Data;

@Data
public class CommonExportReqVO extends UrlConfigReqVO {
    private String exportType;
    private String exportName;
    private String fileType;
}
