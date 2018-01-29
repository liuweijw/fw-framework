package com.liuweijw.api.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.liuweijw.api.config.FwFreemarkerView;

@EnableTransactionManagement
// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@ComponentScan(value = { "com.liuweijw.api.logger", "com.liuweijw.api.config",
		"com.liuweijw.api.filter", "com.liuweijw.api.security", "com.liuweijw.api.web" })
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Bean
	public CommandLineRunner customFreemarker(FreeMarkerViewResolver resolver) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				// 增加视图
				resolver.setViewClass(FwFreemarkerView.class);
				// 添加自定义解析器
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
