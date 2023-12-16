package com.zerodha.backend.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:4200","https://zerotha-legacy.vercel.app","http://localhost:53741")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
