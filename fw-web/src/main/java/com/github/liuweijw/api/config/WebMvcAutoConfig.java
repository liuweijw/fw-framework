package com.github.liuweijw.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.liuweijw.api.filter.LoginInterceptor;

@Configuration
public class WebMvcAutoConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations(
				"classpath:/static/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册监控拦截器
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}
