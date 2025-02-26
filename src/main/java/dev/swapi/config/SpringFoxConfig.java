package dev.swapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Optional;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage("dev.swapi"))
                .paths(PathSelectors.any())
                .build()
                .genericModelSubstitutes(Optional.class);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Case - SWAPI")
                .description("The Star Wars API")
                .version("1.0.0")
                .build();
    }

}
