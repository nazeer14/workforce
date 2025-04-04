package com.pack.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all controllers
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")  // Allow frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE");  // Specify allowed HTTP methods
    }
}
