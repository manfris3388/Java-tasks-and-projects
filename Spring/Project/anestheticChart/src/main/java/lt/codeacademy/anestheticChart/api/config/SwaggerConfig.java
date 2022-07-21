package lt.codeacademy.anestheticChart.api.config;

import lt.codeacademy.anestheticChart.commons.swagger.OpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(OpenApi.class))
                .build();
    }

    private static ApiInfo getInfo() {
        return new ApiInfo(
                "Anesthetic Chart RestFull Api Documentation",
                "This is simple documentation using Swagger and SpringFox",
                "0.0.1",
                "Anesthetic Chart term URL",
                new Contact("Vardenis Pavardenis", "www.codeacademy.lt", "a@codeacademy.lt"),
                "Anesthetic Chart licence",
                "Licence URL",
                Collections.emptyList()
        );
    }
}
