package com.alten.challenge.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean(name = "modelMapper")
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
