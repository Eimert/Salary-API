package nl.eimertvink.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("nl.eimertvink.repository.EmployeeRepository"))
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant("/api/*"))
                .build()
                .apiInfo(buildMetadata());
    }

    private ApiInfo buildMetadata() {
        return new ApiInfoBuilder()
                .title("Salary-API")
                .description("Data from City of Chicago employees")
                .version("1.0")
                .contact(new Contact("Eimert Vink", "eimertvink.nl", "eimertvink@gmail.com"))
                .build();
    }
}
