package com.ram.config;
/**
 * @author NaveenWodeyar
 * @date 20-Sept-2024
 */
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("JAVA,JWT")
                        .description("Spring Boot demo project for spring_security")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Naveen K Wodeyar")
                                .url("http://naveen.co.in")
                                .email("naveenwodeyar@yahoo.com"))
                        .license(new License()
                                .name("My License")
                                .url("http://www.license.co.in"))
                );
    }
}