package com.tiscon11.question.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // すべてのAPIエンドポイントにCORSを適用
                        .allowedOrigins("http://localhost:5173")  // フロントエンドのURL
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 許可するHTTPメソッド
                        .allowCredentials(true);
            }
        };
    }
}