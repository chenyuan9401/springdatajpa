package com.yccc.config;

import com.yccc.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 接下来我们需要将SessionInterceptor拦截器添加到SpringBoot的配置中，
 * 让SpringBoot项目有这么一个拦截器存在，我们新创建一个SessionConfiguration，将拦截器的配置以及拦截路径配置好
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
