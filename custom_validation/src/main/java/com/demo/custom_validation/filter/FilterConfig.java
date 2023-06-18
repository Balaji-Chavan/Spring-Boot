package com.demo.custom_validation.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<CustomFilter> customFilterRegistrationBean() {
        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new CustomFilter());
        registrationBean.addUrlPatterns("/*"); // Apply the filter to all URLs

        return registrationBean;
    }
}