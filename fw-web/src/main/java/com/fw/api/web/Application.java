package com.fw.api.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.fw.api.config.FwFreemarkerView;

@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@EnableScheduling
@ComponentScan(value = { 
	"com.fw.api.logger","com.fw.api.config","com.fw.api.ex","com.fw.api.secure","com.fw.api.web"
})
public class Application extends SpringBootServletInitializer {

	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(Application.class);  
    }
	
	@Bean  
	public CommandLineRunner customFreemarker(FreeMarkerViewResolver resolver) {  
	    return new CommandLineRunner() {  
	        @Override  
	        public void run(String... strings) throws Exception {  
	        	//增加视图  
	            resolver.setViewClass(FwFreemarkerView.class);  
	            //添加自定义解析器  
	        }  
	    };  
	}  
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
