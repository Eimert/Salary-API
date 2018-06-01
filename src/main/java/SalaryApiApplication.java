package nl.eimertvink.salaryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * salary from City of Chicago employees: data.cityofchicago.org
 */
@SpringBootApplication
public class SalaryApiApplication {

	public static void main(String[] args) {

        SpringApplication.run(SalaryApiApplication.class, args);
	}


}
