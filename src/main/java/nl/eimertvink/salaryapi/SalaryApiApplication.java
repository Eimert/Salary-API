package nl.eimertvink.salaryapi;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
/*
 * salary from City of Chicago employees: data.cityofchicago.org
 */
@SpringBootApplication
public class SalaryApiApplication {

	public static void main(String[] args) {

        SQLiteJDBCDriverConnection.connect();

        SelectStatements select = new SelectStatements();
//        select.selectDepartment();
        SpringApplication.run(SalaryApiApplication.class, args);
        MainController mc = new MainController();
//        SQLiteJDBCDriverConnection dbConn = new SQLiteJDBCDriverConnection();
	}

}
