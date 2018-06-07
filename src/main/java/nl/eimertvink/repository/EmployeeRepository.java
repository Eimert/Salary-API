package nl.eimertvink.repository;


import nl.eimertvink.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findMe();

    String topInternalEarner();

    List<Employee> listAllEmployees();
}
