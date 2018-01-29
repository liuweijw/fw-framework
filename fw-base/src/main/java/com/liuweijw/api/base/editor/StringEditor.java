package com.liuweijw.api.base.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * 防止表单注入
 * 
 * @author liuweijw
 *
 */
public class StringEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		setValue(text == null ? null : StringEscapeUtils.escapeHtml4(text
				.trim()));
	}

	@Override
	public String getAsText() {
		Object value = getValue();
		return value != null ? value.toString() : "";
	}

}
