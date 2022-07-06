package com.microservicestutorial.usermanagement.swaggertest;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Profile("!test")
@Configuration
@EnableSwagger2
//@EnableWebMvc
public class SwaggerConfig {


    @Bean
    /*public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }
    private Predicate<String> postPaths() {
        return or (regex("/api/v1/persons"),regex("/api/v1/persons/"));
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("JavaInUse API").build();
               /* .description("JavaInUse API reference for developers")
                .termsOfServiceUrl("http://javainuse.com")
                .licenseUrl("javainuse@gmail.com").version("1.0").build();
    }*/



    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /*public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.microservicestutorial.usermanagement.swaggertest")).build();
    }*/


}
