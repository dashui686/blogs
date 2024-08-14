package com.dashui.blogs.freamwork.config;

import com.dashui.blogs.freamwork.web.filter.ExceptionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


    @Bean
    public FilterRegistrationBean exceptionFilterRegistration(ExceptionFilter exceptionFilter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(exceptionFilter);
        registration.setName("exceptionFilter");
        //此处尽量小，要比其他Filter靠前
        registration.setOrder(-1);
        return registration;
    }

}
