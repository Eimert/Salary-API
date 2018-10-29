package nl.eimertvink.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    @Bean
    public Docket docket() {
//        final List<Parameter> parameters = Stream.of(createHeaderParam())

        return new Docket(DocumentationType.SWAGGER_2)
                .tags(new Tag("Employee Entity", "Repository for Employee entities"))
                .select()
                .apis(RequestHandlerSelectors.any())
//                .apis(RequestHandlerSelectors.basePackage("nl.eimertvink.repository.EmployeeRepository"))
//                .apis(RequestHandlerSelectors.basePackage("nl.eimertvink.repository"))
//                .paths(PathSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build()
//                .pathMapping("/api")
                .apiInfo(buildMetadata());
    }

    private ApiInfo buildMetadata() {
        return new ApiInfoBuilder()
                .title("Salary-API")
                .description("Employee data from the City of Chicago. API test credentials: admin admin")
                .version("2.0")
                .contact(new Contact("Eimert Vink", "https://github.com/Eimert/Salary-API", "eimertvink@gmail.com"))
                .build();
    }

//    private Parameter createHeaderParam(String name, String description, String defaultValue) {
//        return new Parameter(name, description, defaultValue, true, false,
//                false,
//                new ModelRef("string"),
//                Optional.absent(),
//                null,
//                null,
//                "header",
//                false,
//                "",
//                "",
//                "",
//                "",
//                "",
//                "");
//    }
}
