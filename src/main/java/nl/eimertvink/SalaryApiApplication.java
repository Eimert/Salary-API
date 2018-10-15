package nl.eimertvink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * salary from City of Chicago employees: data.cityofchicago.org
 */
@SpringBootApplication
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class SalaryApiApplication {
	public static void main(String[] args) {

        SpringApplication.run(SalaryApiApplication.class, args);

	}


}
