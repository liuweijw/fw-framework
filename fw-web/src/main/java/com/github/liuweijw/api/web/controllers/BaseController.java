package com.github.liuweijw.api.web.controllers;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.github.liuweijw.api.base.editor.DateEditor;
import com.github.liuweijw.api.base.editor.StringEditor;

public abstract class BaseController {

	/**
	 * 初始化数据绑定 1. 将所有传递进来的String进行HTML编码，防止XSS攻击 2. 将字段中Date类型转换为String类型
	 *
	 * @param binder
	 *            the binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
		binder.registerCustomEditor(String.class, new StringEditor());
		// Date 类型转换
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

}
