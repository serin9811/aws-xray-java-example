package com.example.xraytest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

    @Bean
    public Filter SimpleCORSFilter() {
        return new SimpleCORSFilter();
    }

}
