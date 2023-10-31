package com.javaapi.test.spring.spring.pattern.templatev3.enums;



import java.util.HashMap;
import java.util.Map;

/**
 */
public enum ExportTypeEnum {
    /**
     * 导出文件-业务中台提供导出文件得接口
     */
    EXPORT_FILE_TEMPLATE("3", "导出文件模板", "3", "导出文件流", null),
    ;

    /**
     * 导出模板类型 1、通用配置导出模板 2、通用导出模板
     */
    private String exportTemplate;
    /**
     * 导出模板描述
     */
    private String exportTemplateDesc;
    /**
     * 导出类型 1、导出通用配置 2、导出商品 3.文件接口导出
     */
    private String exportType;
    private String exportTypeDesc;
    private Class aClass;

    private static final Map<String, ExportTypeEnum> map = new HashMap<>();

    static {
        for (ExportTypeEnum value : ExportTypeEnum.values()) {
            map.put(value.getExportType(), value);
        }
    }

    ExportTypeEnum(String exportTemplate, String exportTemplateDesc, String exportType, String exportTypeDesc, Class aClass) {
        this.exportTemplate = exportTemplate;
        this.exportTemplateDesc = exportTemplateDesc;
        this.exportType = exportType;
        this.exportTypeDesc = exportTypeDesc;
        this.aClass = aClass;
    }


    public static ExportTypeEnum getaClassByExportType(String exportType) {
        return map.get(exportType);
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public String getExportTypeDesc() {
        return exportTypeDesc;
    }

    public void setExportTypeDesc(String exportTypeDesc) {
        this.exportTypeDesc = exportTypeDesc;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public String getExportTemplate() {
        return exportTemplate;
    }

    public void setExportTemplate(String exportTemplate) {
        this.exportTemplate = exportTemplate;
    }

    public String getExportTemplateDesc() {
        return exportTemplateDesc;
    }

    public void setExportTemplateDesc(String exportTemplateDesc) {
        this.exportTemplateDesc = exportTemplateDesc;
    }
}
