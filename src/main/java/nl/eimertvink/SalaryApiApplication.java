package nl.eimertvink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * salary from City of Chicago employees: data.cityofchicago.org
 */
@SpringBootApplication
public class SalaryApiApplication {



	public static void main(String[] args) {


//		EntityManager em = emf.createEntityManager();

        SpringApplication.run(SalaryApiApplication.class, args);

	}


}
