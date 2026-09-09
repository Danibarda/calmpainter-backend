package com.calmpainter.calm.painter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Allows the frontend origin(from .env) to call the REST endpoints
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${CORS_ALLOWED_ORIGIN}")
    private String allowedOrigin;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigin)
                .allowedMethods("GET", "POST", "OPTIONS");
    }

}
