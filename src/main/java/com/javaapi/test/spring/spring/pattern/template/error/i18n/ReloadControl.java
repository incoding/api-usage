package com.javaapi.test.spring.spring.pattern.template.error.i18n;


import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 资源文件加载控制器
 */
public class ReloadControl {

    /**
     * Always reload resources
     */
    static class Always extends ResourceBundle.Control {
        private boolean needsReload = true;

        @Override
        public long getTimeToLive(String baseName, Locale locale) {
            if (needsReload) {
                return 0;
            }
            return ResourceBundle.Control.TTL_NO_EXPIRATION_CONTROL;
        }

        @Override
        public boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle, long loadTime) {
            // Do not cache, always reload
            return true;
        }

    }
}

