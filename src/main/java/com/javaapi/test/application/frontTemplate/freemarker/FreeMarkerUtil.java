package com.javaapi.test.application.frontTemplate.freemarker;

import java.io.*;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;


public class FreeMarkerUtil {
	
    public static Logger logger = LoggerFactory.getLogger(FreeMarkerUtil.class);

    /**
     * 生成静态文件.
     * 
     * @param vsource
     *            模板文件名
     * @param propMap
     *            用于处理模板的属性Object映射
     * @param vpath
     *            要生成的静态文件的路径,相对设置中的根路径
     * @param vtarget
     *            要生成的文件名,例如 "1.htm"
     */
    @SuppressWarnings("unchecked")
    public static boolean geneHtmlFile(String vsource, Map propMap, String vpath, String vtarget) {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        Writer out = null;
        try {
            Configuration freemarker_cfg = new Configuration();
            freemarker_cfg.setDirectoryForTemplateLoading(new File(vpath));
            freemarker_cfg.setObjectWrapper(new DefaultObjectWrapper());
            freemarker_cfg.setDefaultEncoding("UTF-8");
            freemarker_cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            // setTemplateUpdateDelay  设置为0，表示立刻加载模板   @see http://freemart.iteye.com/blog/1086211
            freemarker_cfg.setTemplateUpdateDelay(0);
            Template template = freemarker_cfg.getTemplate(vsource);
            template.setEncoding("UTF-8");
			template.setClassicCompatible(true);
            creatDirs(vpath);
            File afile = new File(vpath + vtarget);
            fos = new FileOutputStream(afile);
            osw = new OutputStreamWriter(fos, "UTF-8");
            out = new BufferedWriter(osw);
            template.process(propMap, out);
            out.flush();
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
            
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
        }
        return true;
    }
    public static boolean geneHtmlFileToString(String vsource, Map propMap, String vpath, String vtarget) {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        Writer out = null;
        try {
            Configuration freemarker_cfg = new Configuration();
            freemarker_cfg.setDirectoryForTemplateLoading(new File(vpath));
            freemarker_cfg.setObjectWrapper(new DefaultObjectWrapper());
            freemarker_cfg.setDefaultEncoding("UTF-8");
            freemarker_cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            // setTemplateUpdateDelay  设置为0，表示立刻加载模板   @see http://freemart.iteye.com/blog/1086211
            freemarker_cfg.setTemplateUpdateDelay(0);
            Template template = freemarker_cfg.getTemplate(vsource);
            template.setEncoding("UTF-8");
            template.setClassicCompatible(true);
            File afile = new File(vpath + vtarget);
            fos = new FileOutputStream(afile);
            osw = new OutputStreamWriter(fos, "UTF-8");
//            out = new BufferedWriter(osw);
//            PrintStream out1 = System.out;
            out = new BufferedWriter(osw = new OutputStreamWriter(System.out, "UTF-8"));

            template.process(propMap, out);
            out.flush();
        } catch (TemplateException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            return false;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            }
        }
        return true;
    }

    /**
     * 创建多级目录
     * 
     * @param aParentDir
     *            String
     * @param aSubDir
     *            以 / 开头
     * @return boolean 是否成功
     */
    public static boolean creatDirs(String path) {
        File aFile = new File(path);
        if (!aFile.exists()) {
            return aFile.mkdirs();
        } else {
            return true;
        }
    }

 }