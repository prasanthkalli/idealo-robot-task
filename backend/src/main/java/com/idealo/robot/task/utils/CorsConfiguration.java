package com.idealo.robot.task.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("development")
public class CorsConfiguration implements WebMvcConfigurer {
 
	/*
	 * Configuration created to allow calls from localhost:4200/
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/robot/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS");
    }
}