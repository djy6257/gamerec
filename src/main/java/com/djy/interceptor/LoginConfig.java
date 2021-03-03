package com.djy.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //添加资源映射
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        InterceptorRegistration interceptorRegistry = registry.addInterceptor(new LoginInterceptor());
        //拦截所有路径
        interceptorRegistry.addPathPatterns("/**");
        interceptorRegistry.excludePathPatterns(
                "/login",
                "/loginIn" ,
                "/verifyCode",
                "/static/**"
        );

    }

}
