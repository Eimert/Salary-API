package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.CustomizedEmployeeRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeService extends CrudRepository<Employee, Integer>, CustomizedEmployeeRepository {
    // Customized:
    String topInternalEarner();
    void deleteByName(String name);

    List<Employee> getCommonSurname();
    List<Employee> getCommonFirstname();
    List<Employee> getAverageSalaryBySex();

}
