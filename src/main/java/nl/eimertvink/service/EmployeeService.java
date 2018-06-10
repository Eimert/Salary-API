package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import nl.eimertvink.repository.CustomizedEmployeeRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeService extends CrudRepository<Employee, Integer>, CustomizedEmployeeRepository {
    // Customized:
    String topInternalEarner();


}
