package nl.eimertvink.service;

import nl.eimertvink.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeService {

    // Customized:
    String queryByMaxInternalSalary();
    void deleteByName(String name);
    void deleteById(Integer id);

    List<Employee> findAll();
//    Iterable<Employee> listAllEmployees();
    String getOne(Integer id);


}
