package com.evolyb.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }


    // Configuration for Swagger 2
    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // Select which resource to show on API Document
                .paths(PathSelectors.ant("/api/**"))
                // Select which package to show on API Document
                .apis(RequestHandlerSelectors.basePackage("com.evolyb.swagger"))
                .build()
                .apiInfo(apiDetails());
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Student API",
                "Simple API",
                "1.0",
                "Free to Use",
                new Contact("Evolyb","http://google.com","neu@gmail.com"),
                "API License",
                "http://google.com",
                Collections.emptyList()
        );
    }
}

