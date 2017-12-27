package com.fw.api.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * 自定义配置Freemarker全局变量
 * 
 * @author liuweijw
 *
 */
public class FwFreemarkerView extends FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		model.put("context", request.getContextPath());
		super.exposeHelpers(model, request);
	}

}
