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
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/jQuery/**").addResourceLocations("classpath:/static/jQuery/").setCachePeriod(31556926);
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
        registry.addViewController("/logout");
    }
}