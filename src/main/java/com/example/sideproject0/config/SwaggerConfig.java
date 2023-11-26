package com.example.sideproject0.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    // 접속주소 http://localhost:8080/swagger-ui/index.html
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(this.apiInfo())
                ;
                
    }
    
    private Info apiInfo() {
        return new Info()
                .title("Side Project")
                .version("1.0");
    }
}
