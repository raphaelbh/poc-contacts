package com.zup.contacts.contact.adapter.in.web.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class OpenApiConfiguration implements WebMvcConfigurer {

    @Value("${api.version}")
    private String apiVersion;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui.html");
    }

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
            .info(new Info()
                    .title("Contacts Management")
                    .description("Api that provides services for creating and searching for contacts " +
                            "whose objective is to put into practice knowledge acquired during the studies of the hexagonal architecture " +
                            "and the dynamodb.")
                    .version(apiVersion)
            );

    }
}
