package com.javaapi.test.application.frontTemplate.freemarker;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


public class TestFreeMarkerFeature {
    /**
     * 
     * 宏是和某个变量关联的模板片断，以便在模板中通过用户定义指令使用该变量，
     */
    @Test
    public void testMacro(){
        String freemarkerName = "testmacro.ftl";
        String freemarkerHtml = "testmacro.shtml";
        String path2 = TestFreeMarker.class.getResource("").getPath();
        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
    }
    @Test
    public void testStop(){
    	String freemarkerName = "teststop.ftl";
    	String freemarkerHtml = "teststop.shtml";
    	String path2 = TestFreeMarker.class.getResource("").getPath();
    	Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
    	FreeMarkerUtil.geneHtmlFile(freemarkerName, map, path2, freemarkerHtml);
    }
}
