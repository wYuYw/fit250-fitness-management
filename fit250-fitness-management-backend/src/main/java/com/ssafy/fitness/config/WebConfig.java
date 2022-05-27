package com.ssafy.fitness.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.fitness.interceptor.JWTInterceptor;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	// CORS
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("GET","POST","PUT","DELETE")
		.maxAge(6000);
	}

	
//	@Autowired
//	private JWTInterceptor jwtInterceptor;
//	
//	// Interceptor
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(jwtInterceptor)
////		.addPathPatterns("/**")
////		.excludePathPatterns("/api/login")
//		.addPathPatterns("/api/video");
//	}
}
