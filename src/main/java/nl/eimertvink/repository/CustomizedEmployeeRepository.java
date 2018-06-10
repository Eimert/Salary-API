package nl.eimertvink.repository;

import nl.eimertvink.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomizedEmployeeRepository {

    String topInternalEarner();

    List<Employee> getCommonSurname();
    List<Employee> getCommonFirstname();
    List<Employee> getAverageSalaryBySex();
}
