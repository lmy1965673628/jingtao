package com.ly.config;

import com.ly.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


@Configuration
public class MvcConfigurer implements WebMvcConfigurer{
	
	@Resource
	private UserInterceptor userInterceptor;
	
	//开启匹配后缀型配置
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		
		configurer.setUseSuffixPatternMatch(true);
	}
	
	//添加拦截器配制
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(userInterceptor)
		.addPathPatterns("/cart/**","/order/**");
		//如果有多个拦截器,可以addInterceptor多次
	}

}
