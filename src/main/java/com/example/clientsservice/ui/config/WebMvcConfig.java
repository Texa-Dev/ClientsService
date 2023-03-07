package com.example.clientsservice.ui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/accounts")
                .setViewName("accounts");
        registry.addViewController("/authorization")
                .setViewName("authorization");
        registry.addViewController("/clients")
                .setViewName("clients");
        registry.addViewController("/countries")
                .setViewName("countries");
        registry.addViewController("/registration")
                .setViewName("registration");
        registry.addViewController("/users")
                .setViewName("users");
    }
}