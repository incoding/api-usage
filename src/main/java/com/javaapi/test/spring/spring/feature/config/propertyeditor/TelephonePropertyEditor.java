package com.javaapi.test.spring.spring.feature.config.propertyeditor;

import java.beans.PropertyEditorSupport;

/**

 */
public class TelephonePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text.matches("^\\d+\\-\\d+$")) {
            String[] strs = text.split("\\-");
            setValue(new Telephone(strs[0], strs[1]));
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getAsText() {
        return ((Telephone) getValue()).toString();
    }
}