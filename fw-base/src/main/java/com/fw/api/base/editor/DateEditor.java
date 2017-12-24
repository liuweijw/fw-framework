package com.fw.api.base.editor;

import java.beans.PropertyEditorSupport;

import com.fw.api.base.util.DateHelper;

/**
 * 防止表单注入
 * 
 * @author LW
 *
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
