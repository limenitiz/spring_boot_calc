package com.example.neoflex_test_task.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfig {
    @Bean
    public GroupedOpenApi config() {
        return GroupedOpenApi.builder()
                .group("default-api")
                .pathsToExclude("/")
                .pathsToMatch("/**")
                .build();
    }
}
