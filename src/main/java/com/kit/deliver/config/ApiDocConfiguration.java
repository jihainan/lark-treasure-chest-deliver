package com.kit.deliver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName ApiDocConfiguration
 * @Description Swagger2 configuration generating interface document
 * @Author jihainan
 * @Date 2021/10/29 10:55 上午
 * @Version 1.0
 */
@Configuration
public class ApiDocConfiguration {

    /**
     * Group DeliverTask contains operations related to publish deliver task
     */
    @Bean
    public Docket swaggerDeliverTaskApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("DeliverTask")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kit.deliver.controller.v1.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Group Message contains operations related to obtain messages by user info
     */
    @Bean
    public Docket swaggerMessageApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Message")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kit.deliver.controller.v1.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * Declare application information
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Deliver Kit - REST APIs")
                .description("Deliver kit for everything based on Spring Boot").termsOfServiceUrl("")
                .contact(new Contact("jihainan", "https://github.com/jihainan", "alwaysbegoing@163.com"))
                .license("Private License")
                .licenseUrl("https://github.com/jihainan")
                .version("1.0")
                .build();
    }
}
