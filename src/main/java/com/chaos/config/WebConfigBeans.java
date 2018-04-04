package com.chaos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class WebConfigBeans {
    @Resource
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void initBinder(){
        ConfigurableWebBindingInitializer initializer=(ConfigurableWebBindingInitializer)requestMappingHandlerAdapter.getWebBindingInitializer();
        if (initializer.getConversionService() != null) {
            GenericConversionService genericConversionService = (GenericConversionService) initializer.getConversionService();
            genericConversionService.addConverter(new StringToDateConverter());
        }
    }



}
