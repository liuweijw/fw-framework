package com.liuweijw.api.base.editor;

import java.beans.PropertyEditorSupport;

import com.liuweijw.api.base.util.DateHelper;

/**
 * 防止表单注入
 * 
 * @author liuweijw
 *
 */
public class DateEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		setValue(DateHelper.parseDate(text));
	}

}
