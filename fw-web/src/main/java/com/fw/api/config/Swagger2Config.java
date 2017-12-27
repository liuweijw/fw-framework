package com.fw.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("full-petstore-api")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fw.api.web.controllers"))
				// .paths(petstorePaths())
				.paths(PathSelectors.any()).build()
				// .securitySchemes(Lists.newArrayList(apiKey()))
				// .securityContexts(newArrayList(securityContext()))
				;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("利用Springboot和Swagger2构建的RESTful APIs")
				.description("前端使用此Api的应用：https://github.com/liuweijw/Vue2-All")
				.termsOfServiceUrl("https://github.com/liuweijw/")
				.contact(new Contact("liuweijw", "", "")).version("1.0")
				.build();
	}

	/*
	 * private static String [] paths = new String [] { "/version/","/users/" };
	 * 
	 * private Predicate<String> petstorePaths() { return new
	 * Predicate<String>(){
	 * 
	 * @Override public boolean apply(String input) { for(String path : paths){
	 * if(input.contains(path)) return true; } return false; } }; }
	 */

}
