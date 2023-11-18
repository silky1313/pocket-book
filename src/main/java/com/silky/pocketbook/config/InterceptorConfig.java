package com.silky.pocketbook.config;

import com.silky.pocketbook.interceptor.AuthenticationInterceptor;
import com.silky.pocketbook.interceptor.CorsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
    }
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
    @Bean
    public CorsInterceptor corsInterceptor() {
        return new CorsInterceptor();
    }
}
