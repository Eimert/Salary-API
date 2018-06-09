package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeService extends CrudRepository<Employee, Integer> {
//
//    List<Employee> findMe();
//    String topInternalEarner();
//    List<Employee> listAllEmployees();

}
