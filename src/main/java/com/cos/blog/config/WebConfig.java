package com.cos.blog.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.blog.config.aop.RoleIntercepter;
import com.cos.blog.config.aop.SessionIntercepter;

//필터링(실제로 web.xml파일을 오버라이드)

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionIntercepter())
		.addPathPatterns("/user/**")
		.addPathPatterns("/post/**")//로그인 안하면 글 아무것도 못 보게 할거다.
		.addPathPatterns("/post**");
		
		registry.addInterceptor(new RoleIntercepter())
		.addPathPatterns("/admin/**");
	}
}
