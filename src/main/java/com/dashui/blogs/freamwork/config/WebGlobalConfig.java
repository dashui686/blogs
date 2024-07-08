package com.dashui.blogs.freamwork.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

// @Configuration  继承 WebMvcConfigurationSupport 后 所有 WebMvcConfiguration 接口失效
public class WebGlobalConfig extends WebMvcConfigurationSupport {

    // 导致一系列序列化问题
    // @Override
    // protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    //     super.configureMessageConverters(converters);
    //     converters.add(mappingJackson2HttpMessageConverter());
    // }
    // /**
    //  * 自定义mappingJackson2HttpMessageConverter
    //  * 目前实现：空值忽略，空字段可返回
    //  */
    // private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    //     objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    //     return new MappingJackson2HttpMessageConverter(objectMapper);
    // }
}
